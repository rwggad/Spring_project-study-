package conn.member.controller;

import conn.member.Member;
import conn.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class MemberController {

    @Autowired
    MemberService service;

    @RequestMapping(value = "/memJoin")
    public String memJoin(Model model, HttpServletRequest request){
        /**
         * 회원 등록*/

        /**
         * memJoin.html 에서 넘어온 파라미터 (request) 를 String 형태로 저장한다. */
        String memId = request.getParameter("memId");
        String memPw = request.getParameter("memPw");
        String memMail = request.getParameter("memMail");
        String memPhone1 = request.getParameter("memPhone1");
        String memPhone2 = request.getParameter("memPhone2");
        String memPhone3 = request.getParameter("memPhone3");

        /**
         * 그리고 service 에 등록해준다*/
        service.memberRegister(memId, memPw, memMail, memPhone1,memPhone2,memPhone3);

        /**
         * 등록후 회원 정보를  memJoinOk.jsp 에 넘겨준다. */
        model.addAttribute("memId", memId);
        model.addAttribute("memPw", memPw);
        model.addAttribute("memMail", memId);
        model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
        return "memJoinOk";
    }

    @RequestMapping(value = "/memLogin")
    public String login(Model model, HttpServletRequest request){
        /**
         * 회원 로그인*/

        /**
         * login.html 에서 넘어온 파라미터 (request) 를 String 형태로 저장한다. */
        String memId = request.getParameter("memId");
        String password = request.getParameter("memPw");

        Member member = service.memberSearch(memId, password);

        try{
            model.addAttribute("memId", member.getMemId());
            model.addAttribute("memPw", member.getMemPw());
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return "memLoginOk";
    }
}
