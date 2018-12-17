package conn.controller;

import conn.Model.Board;
import conn.Model.Member;
import conn.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/BoardSystem")
public class BoardController {

    @Autowired
    BoardService service;

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


    @RequestMapping("/HomeForm")
    public String HomeForm(Model model, Board board){
        model.addAttribute("boardList", service.GetList());
        return "/BoardSystem/HomeForm";
    }

    /** Insert */
    @RequestMapping("/InsertForm")
    public String InsertForm(Model model, Board board, HttpSession session){
        Member tryMember = (Member) session.getAttribute("memberSession");
        model.addAttribute("tryMember", tryMember);
        return "/BoardSystem/InsertForm";
    }
    @RequestMapping(value = "Insert", method = RequestMethod.POST)
    public String Insert(Board board){
        if(service.Register(board) > 0){
            return "redirect:/BoardSystem/HomeForm";
        }else{
            return "BoardSystem/dbFail";
        }
    }

    /** Delete */
    @RequestMapping(value = "/Delete", method = RequestMethod.POST)
    public String Delete(Board board){
        if(service.Remove(board) > 0){
            return "redirect:/BoardSystem/HomeForm";
        }else{
            return "BoardSystem/dbFail";
        }
    }

}
