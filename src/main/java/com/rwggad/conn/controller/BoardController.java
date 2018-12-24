package com.rwggad.conn.controller;

import com.rwggad.conn.Model.BaordModel.Board;
import com.rwggad.conn.Model.LoginModel.Member;
import com.rwggad.conn.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String HomeForm(Model model, Map<String, Object> commandMap){
        List<Map<String, Object>> list = service.selectBoardList(commandMap);
        model.addAttribute("list", list);
        return "/BoardSystem/HomeForm";
    }

}
