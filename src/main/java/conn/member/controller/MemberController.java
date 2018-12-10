package conn.member.controller;

import conn.member.Member;
import conn.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/member") // 맵핑할때 공통된 부분 삽입
public class MemberController {

    @Autowired
    MemberService service;

     /**
     * HttpServletRequest requset를 이용해서 html 파라미터를 가져오는 방법 (가장 기본)
     * */
    @RequestMapping(value = "/memJoin", method = RequestMethod.POST) // Post 방식으로 정보가 전달되었나?
    /*public String memJoin(Model model, HttpServletRequest request){
        //회원등록..
        //memJoin.html 에서 넘어온 파라미터 (request) 를 String 형태로 저장한다.
        String memId = request.getParameter("memId");
        String memPw = request.getParameter("memPw");
        String memMail = request.getParameter("memMail");
        String memPhone1 = request.getParameter("memPhone1");
        String memPhone2 = request.getParameter("memPhone2");
        String memPhone3 = request.getParameter("memPhone3");

        //그리고 service 에 등록해준다
        service.memberRegister(memId, memPw, memMail, memPhone1,memPhone2,memPhone3);

        //등록후 회원 정보를  memJoinOk.jsp 에 넘겨준다.
        model.addAttribute("memId", memId);
        model.addAttribute("memPw", memPw);
        model.addAttribute("memMail", memId);
        model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
        return "memJoinOk";
    }*/
    /**
     * Member 객체 이용
     * Paramater 에서 자동으로 Member 인스턴스에 등록된다.
     * 클래스에 getter setter가 무조건 있어야한다.
     * get 으로 사용하면된다.
     * */
    public String memJoin(Member member){
        service.memberRegister(member.getMemId(), member.getMemPw(), member.getMemMail(),
                member.getMemPhone1(), member.getMemPhone2(), member.getMemPhone3());
        return "memJoinOk";
    }

    /**
     * login.html 에서 넘어온 파라미터 (request) 를 String 형태로 저장한다.
     *
     * annotation 을 이용해서 html 파라미터를 가져오는 방법
     * (required 속성 값이 true 이면 값이 없을 때 예외 처리를 발생 시킨다.)
     * 만약 defaultValue값을 설정하면 사용자가 값을 입력안하면 defaultValue 로 대체한다.
     * */
    @RequestMapping(value = "/memLogin", method = RequestMethod.POST)
    public String login(Model model, @RequestParam("memId") String memId,
                        @RequestParam(value = "memPw", required = true, defaultValue = "") String password){
        /**
         * 회원 로그인*/

        /**
         * Mapdb에 저장된 회원 정보 가져오기 */
        Member member = service.memberSearch(memId, password);

        /**
         * try로 안전하게~*/
        try{
            model.addAttribute("memId", member.getMemId());
            model.addAttribute("memPw", member.getMemPw());
        }catch (Exception e){
            System.out.println(e.toString());
        }

        /**
         * memLoginOk.jsp 로 이동*/
        return "memLoginOk";
    }
}
