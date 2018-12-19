package conn.controller;

import conn.Model.ClinicModel.Owner;
import conn.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.ArrayList;
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
        List<Owner> owners_ALL = service.getOwners(); // 전체 목록을 받아옴
        if(owner.getLastName().equals("")){ // 이름을 입력안하면 모든 사람의 정보가 넘어옴
            model.addAttribute("owners", owners_ALL);
        }else{ // 검색창에 사용자가 입력한 lastName 과 같은 owner 정보 만 저장후 넘김
            List<Owner> owners_Select = new ArrayList<Owner>();
            for(int i = 0; i < owners_ALL.size(); i++){
                if(owner.getLastName().equals(owners_ALL.get(i).getLastName())){
                    owners_Select.add(owners_ALL.get(i));
                }
            }
            model.addAttribute("owners", owners_Select);
        }
        return "PetClinic/FindResultForm";
    }


    /** Owner From*/
    @RequestMapping("/OwnerForm")
    public String OwnerForm(Model model, @RequestParam(value = "id") int id){
        Owner owner = service.getOwner(id);
        model.addAttribute("owner", owner);
        return "PetClinic/OwnerForm";
    }

    /** Add New Owner*/
    @RequestMapping("/NewOwnerForm")
    public String NewOwnerForm(Owner owner){
        return "PetClinic/NewOwnerForm";
    }
    @RequestMapping(value = "/NewOwner", method = RequestMethod.POST)
    public String NewOwner(Model model, Owner owner){
        if(owner.getId() == 0){ // 값으로 넘어온 owner의 id가 0 이면 새로운 owner
            service.putOwner(owner);
        }else{ // 아니라면 update (기존에 있던 owner)
            service.modifyOwner(owner);
        }
        model.addAttribute("owner", owner);
        return "PetClinic/OwnerForm";
    }

    /** Edit Owner*/
    @RequestMapping("/EditOwner")
    public String EditOwner(Model model, @RequestParam(value = "id") int id){
        Owner owner = service.getOwner(id);
        model.addAttribute("owner", owner);
        return "PetClinic/NewOwnerForm";
    }
}
