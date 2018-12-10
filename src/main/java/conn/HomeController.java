package conn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller // 컨트롤러
public class HomeController {
    @ModelAttribute("serverTime")
    public String getServerTime(Locale locale) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        return dateFormat.format(date);
    }

    @RequestMapping("/")
    public String home(Model model){
        return "home";
    }


}
