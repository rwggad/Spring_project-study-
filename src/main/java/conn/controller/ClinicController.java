package conn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/PetClinic")
public class ClinicController {

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
    public String FindOwnersForm(){
        return "/PetClinic/FindOwnersForm";
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
