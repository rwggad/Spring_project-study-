package conn.controller;

import conn.Model.ClinicModel.Owner;
import conn.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        if(owner.getLastName().equals("")){ // 이름을 입력안하면 모든 사람의 정보가 넘어옴
            List<Owner> owners = service.getOwners();
            model.addAttribute("Owners", owners);
        }else{
            model.addAttribute("Owners", null);
        }
        return "PetClinic/FindResultForm";
    }

    /** Owner From*/
    @RequestMapping("/OwnerForm")
    public String OwnerForm(Model model, @RequestParam(value = "id") int id){
        Owner owner = service.getOwner(id);
        model.addAttribute("Owner", owner);
        return "PetClinic/OwnerForm";
    }

    /** Add New Owner*/
    @RequestMapping("/NewOwnerForm")
    public String NewOwnerForm(Owner owner){
        return "PetClinic/NewOwnerForm";
    }

    @RequestMapping(value = "/NewOwner", method = RequestMethod.POST)
    public String NewOwner(Model model, Owner owner){
        model.addAttribute("Owner", owner);
        return "PetClinic/OwnerForm";
    }
}
