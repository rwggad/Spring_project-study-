package loginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /** 첫 페이지 */
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
