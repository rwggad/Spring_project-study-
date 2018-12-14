package conn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * xml파일에 명시하지 않고 스프링 컨테이너로 Bean 생성방법 */
//@Service
//@Component
@Repository
public class HomeController {

    /**
     * 컨트롤러가 호출되고, 안의 메서드가 호출될때 서버의 시간을 나타내는 기능을 해준다.
     *
     * @ModelAttribute annotation 을 준 메서드는 어떠한 메서드가 호출될 때 같이 호출이 된다.
     *
     * serverTime로 view에서 바로 사용이 가능*/
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

    @RequestMapping(value = "/")
    public String hello(){
        return "index";
    }
}
