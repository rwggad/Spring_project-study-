package loginSystem.controller;

import loginSystem.Member;
import loginSystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


@Controller
@RequestMapping("/member") // 맵핑할때 공통된 부분 삽입
public class MemberController {

    @Autowired
    MemberService service;

    /**
     * 컨트롤러가 호출되고, 안의 메서드가 호출될때 서버의 시간을 나타내는 기능을 해준다.
     *
     * @ModelAttribute annotation 을 준 메서드는 어떠한 메서드가 호출될 때 같이 호출이 된다.
     *
     * serverTime로 view에서 바로 사용이 가능*/

    @ModelAttribute("cp")
    public String getContextPath(HttpServletRequest request) {
        return request.getContextPath();
    }

    @ModelAttribute("serverTime")
    public String getServerTime(Locale locale) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        return dateFormat.format(date);
    }
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


    /** 회원 등록 jsp 로 이동*/
    @RequestMapping(value = "/joinForm")
    public String joinForm(Member member){
        return "member/joinForm";
    }

    /** 회원 로그인 jsp 로 이동*/
    @RequestMapping(value = "/loginForm")
    public String loginForm(Member member){
        return "member/loginForm";
    }

    /** 회원 로그아웃 jsp 로 이동*/
    @RequestMapping(value = "/logout")
    public String logoutOk(Member member, HttpSession session){
        session.invalidate(); // 세션 삭제
        return "member/logoutOk";
    }

    /** 회원 정보 변경 jsp 로 이동*/
    @RequestMapping(value = "/modifyForm")
    public String modifyForm(Model model, Member member, HttpSession session){
        Member sessionMember = (Member) session.getAttribute("member"); // 현재 세션정보 가져오기
        model.addAttribute("sessionMember", sessionMember); // 그 세션 정보를 기본 데이터로 보여주기위해
        return "member/modifyForm";
    }

    /** 회원 삭제 jsp 로 이동*/
    @RequestMapping(value = "/removeForm")
    public String removeForm(Model model, Member member, HttpSession session){
        Member sessionMember = (Member) session.getAttribute("member"); // 세션 정보 가져오기
        model.addAttribute("sessionMember", sessionMember); // 세션 정보 model로 전달
        return "member/removeForm";
    }

    //-------------------------------------------------------------

    /** 회원 등록 */
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(Member member, HttpSession session){
        if(service.memberRegister(member)){ // 최초 회원이라면
            session.setAttribute("member", member); // 세션등록
            return "member/joinOk";
        }else{ // 이미 등록된 회원이라면
            return "member/joinFail";
        }
    }

    /** 회원 로그인 */
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(Member member, HttpSession session){
        if(service.memberLogin(member) != null){ // 로그인 성공 일때
            session.setAttribute("member", member); // 세션 등록
            return "member/loginOk";
        }else{
            return "member/loginFail";
        }
    }

    /** 회원 수정 */
    @RequestMapping(value ="/modify", method = RequestMethod.POST)
    public String modify(Model model, Member member, HttpSession session){
        Member memAft = service.memberModify(member); // 입력받은 member 값으로 회원 db 정보 수정
        session.setAttribute("member", memAft); // 수정한 값으로 session 수정
        model.addAttribute("memAft", memAft);// Model 객체 생성

        return "member/modifyOk";
    }

    /** 회원 삭제 */
    @RequestMapping(value ="/remove", method = RequestMethod.POST)
    public String remove(Model model, Member member, HttpSession session){
        Member sessionMember = (Member) session.getAttribute("member"); // 세션 가져오기
        if(sessionMember.getMemPw().equals(member.getMemPw())){ // 입력한 비번과 세션의 사용자 비번이 같을 경우
            session.invalidate(); // 세션 삭제
            service.memberRemove(sessionMember);
            return "member/removeOk";
        }else{
            return "member/removeFail";
        }
    }
}
