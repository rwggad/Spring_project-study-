package conn.member.controller;

import conn.member.Member;
import conn.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member") // 맵핑할때 공통된 부분 삽입
public class MemberController {

    @Autowired
    MemberService service;
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

    /** 회원 등록 */
    @RequestMapping(value = "/memJoin", method = RequestMethod.POST) // Post 방식으로 정보가 전달되었나?
    public String memJoin(@ModelAttribute("mem") Member member){
        if(service.memberRegister(member)) { // 회원등록 완료
            return "memJoinOk";
        }else{
            return "memJoinFail";
        }
    }

    /** 회원 로그인 */
    @RequestMapping(value = "/memLogin", method = RequestMethod.POST)
    public String memLogin(@ModelAttribute("mem") Member member){
        // 로그인 정보 전달 후 회원 정보가 있다면 isMember에 회원정보 저장 없다면 null
        Member isMember = service.memberLogin(member.getMemId(), member.getMemPw());
        if(isMember != null){ //
            return "memLoginOk";
        }else{
            return "memLoginFail";
        }
    }

    @RequestMapping(value ="/memModify", method = RequestMethod.POST)
    public String modify(){
        return "memModifyOk";
    }

    @RequestMapping(value ="/memRemove", method = RequestMethod.POST)
    public String remove(@ModelAttribute("mem") Member member){
        if(service.memberRemove(member.getMemId())){ // 삭제 하려는 회원 정보가 있다면 삭제완료
            return "memRemoveOk";
        }else{
            return "memRemoveFail";
        }
    }
}
