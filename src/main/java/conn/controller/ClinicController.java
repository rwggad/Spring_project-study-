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

    /** FindOwnersForm*/
    @RequestMapping("/FindOwnersForm")
    public String FindOwnersForm(Owner owner){
        return "/PetClinic/FindOwnersForm";
    }
    @RequestMapping(value = "/Find", method = RequestMethod.POST)
    public String Find(Model model, Owner owner){
        if(owner.getLastName().equals("")){ // 이름을 입력안하면 모든 사람의 정보가 넘어옴
            List<Owner> owners = service.getOwners();
            model.addAttribute("Owners", owners);
        }else{
            model.addAttribute("Owners", null);
        }
        return "/PetClinic/Find";
    }

    /** VeterinariansForm*/
    @RequestMapping("/VeterinariansForm")
    public String VeterinariansForm(){
        return "/PetClinic/VeterinariansForm";
    }

    /** ErrorForm*/
    @RequestMapping("/ErrorForm")
    public String ErrorForm(){
        return "/PetClinic/ErrorForm";
    }
}
