package com.rwggad.conn.Board;

import com.rwggad.conn.Board.BaordModel.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
    public ModelAndView HomeForm(Map<String, Object> commandMap)
        throws Exception{
        ModelAndView mv = new ModelAndView("/BoardSystem/HomeForm");
        List<Map<String, Object>> list = this.service.selectBoardList(commandMap);
        mv.addObject("list",list);
        return mv;
    }

    /** Insert */
    @RequestMapping("/InsertForm")
    public ModelAndView InsertForm(Board board, HttpSession session){
        ModelAndView mv = new ModelAndView("BoardSystem/InsertForm");
        mv.addObject("tryMember", session.getAttribute("memberSession"));
        return mv;
    }
    @RequestMapping(value="/Insert", method = RequestMethod.POST)
    public ModelAndView Insert(Board board) throws Exception{
        this.service.insertBoard(board);
        ModelAndView mv = new ModelAndView("redirect:/BoardSystem/HomeForm");
        return mv;
    }
}
