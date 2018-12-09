package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨트롤러
public class controller {
    /**
     * MVC 작동 방식 1
     *
     * 사용자가 요청을 했다.
     * ex) "http://localhost:8080/" 여기서 요청은 "/" 이다.
     *
     * DispatcherServlet(DST) 에서 요청을 받는다.
     *
     * DispatcherServlet(DST) 은 HandlerMapping 을 통해서 요청에 맞는 controller 를 찾고 DST 로 넘겨준다.
     *
     * 그리고 DST 은 다시 HandlerAdapter 를 통해서 해당 요청에 맞는 method 를 찾는다.
     * ex)
     *  요청값 == "/"
     *  @RequestMapping(value = "요청값") annotation 이 붙은 method 를 찾는다.
     *
     * 찾았다면 해당 메서드를 실행 하고 Model(model객체) view(return 값) 형태로 값을 DispatcherServlet 로 넘기고
     *
     * 마지막으로 DispatcherServlet 는 ViewResolver 에게 해당 값(Model/view)을 넘긴다.
     * */
    @RequestMapping(value = "/")
    public String hello(Model model){
        model.addAttribute("hello_spring", "HI spring! I am model!"); // Model 값 설정
        return "index"; // ViewResolver 한테 전달 (View 로 사용되는 jsp 이름)
    }
}
