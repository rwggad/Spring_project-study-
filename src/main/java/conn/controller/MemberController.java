package conn.controller;

import conn.Model.LoginModel.Member;
import conn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class MemberController {
    /**
     *  html 파일에서 파라미터를 가져오는 방법은 크게 3가지가 있다.
     *
     *  1. 메서드 매개변수로 HttpServletRequest requst를 사용하는 방법
     *  ex)
     *   public void method(Model model, HttpServletRequest request){
     *       String str = request.getParameter("html.name_tag")
     *       ...
     *
     *       return "jsp"
     *   }
     *
     *   2. @RequestParam annotation 사용하는 벙법
     *    2 - 1 @RequestParam(value = "", required = true) :  required 속성 값이 true 이면 value 에 대한 값이 없을 때 예외 처리를 발생 시킨다.
     *    2 - 2 @RequestParam(value = "", defaultValue = "basic value") :  사용자의 입력값이 없을 때 defaultValue 로 대체한다.
     *
     *   ex)
     *    public void method(Model model, @RequestParam("html.name_tag) String str.. ){
     *        ... (str 자체로 사용하기)
     *
     *        return "jsp"
     *    }
     *
     *  3. 커맨드 객체를 사용하는 방법이다.
     *  커맨드 객체를 사용할 때는 커맨드 객체에 변수명과 html 파일의 input tag 의 name이 같아야하고
     *  getter setter 가 꼭 있어야만 사용 가능하다.
     *
     *  jsp에서는 커맨드 객체 이름으로 . 으로 값을 참조 할 수 있다.
     *
     *   3 - 1 @ModelAttribute 를 사용하면 커맨드 객체의 참조 이름을 바꿀수 있다.
     *    - @ModelAttribute("mem") Member member
     *
     *  ex) Member 커맨드 객체를 사용
     *   public void method(Member member){
     *       ... (member getter를 이용하기)
     *
     *       return "jsp"
     *   }
     *
     *
     * */


    /** 세션 등록
     *
     * Session을 받는 방법은 크게 두가지가 있다.
     *
     * 파라미터로
     * 1. HttpSession  이용
     *   HttpSession session 을 파라미터로 정의하고 session을 그대로 사용하면된다.
     *
     * 2. HttpServletRequest 이용
     *   HttpServletRequest request 로 파라미터로 정의하고
     *   사용할 코드 에 HttpSession session = request.getSession(); 을 하고 사용하면된다.
     * */

    /**
     * Model 객체는 뷰에 데이터만 전달하는 객체
     * ModelAndView 객체는 데이터와 뷰의 이름을 함께 전달하는 객체이다. */

    @Autowired
    MemberService service;

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

    /** Login */
    @RequestMapping("LoginSystem/LoginForm")
    public String LoginForm(Member member, HttpSession session){
        Member isLogin = (Member) session.getAttribute("memberSession");
        if(isLogin == null){ // 로그인 안한 상태에서 접근
            return "LoginSystem/LoginForm";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "LoginSystem/Login", method = RequestMethod.POST)
    public String Login(Member member, HttpSession session){
        if(service.Login(member) > 0){ // 로그인 성공
            Member tryMember = service.Search(member);
            session.setAttribute("memberSession",tryMember); // 세션 등록
            return "redirect:/";
        }else {
            return "LoginSystem/LoginFail";
        }
    }

    /** Join */
    @RequestMapping("LoginSystem/JoinForm")
    public String JoinForm(Member member){
        return "LoginSystem/JoinForm";
    }

    @RequestMapping(value = "LoginSystem/Join", method = RequestMethod.POST)
    public String Join(Member member, HttpSession session){
        if(service.Register(member) > 0){ // 회원 등록 성공일 때
            session.setAttribute("memberSession",member);
            return "redirect:/";
        }else{ // 회원 등록 실패
            return "LoginSystem/JoinFail";
        }
    }

    /** Logout */
    @RequestMapping("LoginSystem/Logout")
    public String Logout(Member member, HttpSession session){
        session.invalidate(); // 세션 삭제
        return "redirect:/";
    }

    /** Remove */
    @RequestMapping("LoginSystem/RemoveForm")
    public String RemoveForm(Model model, Member member, HttpSession session){
        // 현재 세션에 있는 사용자 정보를 넘겨줌
        Member tryMember  = (Member) session.getAttribute("memberSession");
        model.addAttribute("removeMember", tryMember);
        return "LoginSystem/RemoveForm";
    }

    @RequestMapping(value = "LoginSystem/Remove", method = RequestMethod.POST)
    public String Remove(Member member, HttpSession session){
        if(service.Remove(member) > 0){ // 삭제 성공
            session.invalidate(); // 세션 삭제
            return "LoginSystem/RemoveOk";
        }else{
            return "LoginSystem/RemoveFail";
        }
    }

    /** Modify */
    @RequestMapping("LoginSystem/ModifyForm")
    public String ModifyForm(Model model, Member member, HttpSession session){
        Member tryMember = (Member) session.getAttribute("memberSession");
        model.addAttribute("modifyMember", tryMember);
        return "LoginSystem/ModifyForm";
    }

    @RequestMapping(value = "LoginSystem/Modify", method = RequestMethod.POST)
    public String Modify(Member member, HttpSession session){
        if(service.Modify(member) > 0){
            session.setAttribute("memberSession",member);
            return "LoginSystem/ModifyOk";
        }else{
            return "LoginSystem/ModifyFail";
        }
    }
}
