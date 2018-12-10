package conn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨트롤러
public class HomeController {
    @RequestMapping("/")
    public String home(Model model){
        return "home";
    }
}
