package conn.controller;

import conn.Model.ClinicModel.Base.PetType;
import conn.Model.ClinicModel.Owner;
import conn.Model.ClinicModel.Pet;
import conn.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/PetClinic")
public class ClinicController {
    @Autowired
    ClinicService service;

    @ModelAttribute("cp")
    public String getContextPath(HttpServletRequest request){
        return request.getContextPath();
    }

    @ModelAttribute("serverTime")
    public String getServerTime(Locale locale){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        return dateFormat.format(date);
    }

    /** Home */
    @RequestMapping("/HomeForm")
    public String HomeForm(){
        return "/PetClinic/HomeForm";
    }

    /** FindForm*/
    @RequestMapping("/FindForm")
    public String FindOwnersForm(Owner owner){
        return "PetClinic/FindForm";
    }
    @RequestMapping(value = "/Find", method = RequestMethod.POST)
    public String Find(Model model, Owner owner){

        if(owner.getLastName() == null){ // 검색창에 lastName 을 입력하지 않았을 경우
            owner.setLastName(""); // "" 으로 초기화 해줌
        }

        List<Owner> owners = this.service.getOwnersByName(owner.getLastName()); // LastName 에 대한 owner 를 검색해서 들고온다.
        if(owners.isEmpty()){
            // 현재 등록된 owner 가 없는 걍우.
            model.addAttribute("selections", owners);
            return "PetClinic/FindResultForm";
        }else if(owners.size() == 1){
            // 검색된 owner 가 한명일 경우 바로 detail view 를 띄워준다.
            owner = owners.get(0);
            return "redirect:/PetClinic/OwnerDetail/" + owner.getId();
        }else{
            // 검색된 owner 가 여러명일 경우 List 값으로 출력해준다.
            model.addAttribute("selections", owners);
            return "PetClinic/FindResultForm";
        }
    }

    /** Owner From*/
    @RequestMapping("/OwnerDetail/{owner_id}")
    public String OwnerForm(Model model, @PathVariable("owner_id") int owner_id){
        // PathVariable 는 URL 부분에 변수를 넣어주는 기능
        // Mapping에 있는 변수명과 PathVariable 쪽의 변수명을 같게 해주어야한다.
        Owner owner = service.getOwnerById(owner_id);
        model.addAttribute("owner", owner);
        return "PetClinic/OwnerDetail";
    }

    /** Add New Owner*/
    @RequestMapping("/AddOrModifyOwnerForm")
    public String NewOwnerForm(Owner owner){
        return "PetClinic/AddOrModifyOwnerForm";
    }
    @RequestMapping(value = "/AddOrModifyOwner", method = RequestMethod.POST)
    public String AddOwner(Model model, Owner owner){
        int owner_id = owner.getId();
        if(owner.getId() == 0){ // 값으로 넘어온 owner의 id가 0 이면 새로운 owner
            owner_id = service.putOwner(owner);
        }else{ // 아니라면 update (기존에 있던 owner)
            service.modifyOwner(owner);
        }
        return "redirect:/PetClinic/OwnerDetail/" + owner_id;
    }

    /** Add New Pet*/
    @RequestMapping("/AddPetForm")
    public String AddPetForm(Model model, @RequestParam(value = "id") int id, @ModelAttribute("pet") Pet pet){
        Owner owner = service.getOwnerById(id);
        List<PetType> petTypes = service.getPetTypes();
        model.addAttribute("owner", owner);
        model.addAttribute("petTypes", petTypes);
        return "PetClinic/AddPetForm";
    }
    @RequestMapping(value = "/AddPet", method = RequestMethod.POST)
    public String AddPet(@ModelAttribute("pet") Pet pet, HttpServletRequest request){
        pet.setOwner(service.getOwnerById(Integer.parseInt(request.getParameter("owner_id"))));
        pet.setPetType(service.getPetType(Integer.parseInt(request.getParameter("types"))));
        service.putPet(pet);
        return "redirect:/PetClinic/OwnerForm?id=" + pet.getOwner().getId();
    }

    /** Edit Owner*/
    @RequestMapping("/EditOwner/{owner_id}")
    public String EditOwner(Model model, @PathVariable("owner_id") int owner_id){
        Owner owner = service.getOwnerById(owner_id);
        model.addAttribute("owner", owner);
        return "PetClinic/AddOrModifyOwnerForm";
    }

}
