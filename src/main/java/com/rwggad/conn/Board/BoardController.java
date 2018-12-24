package com.rwggad.conn.Board;

import com.rwggad.conn.Board.BaordModel.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public String InsertForm(Board board){
        return "BoardSystem/InsertForm";
    }
}
