package conn.controller;

import conn.Model.Member;
import conn.Model.WordSet;
import conn.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/SearchSystem")
public class WordController {

    @Autowired
    private WordService service;

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

    /** Home Form Location*/
    @RequestMapping("/HomeForm")
    public String Home(Model model){
        List<WordSet> list = service.SearchAll();
        model.addAttribute("wordList", list);
        return "SearchSystem/HomeForm";
    }

    /** insert */
    @RequestMapping("/InsertForm")
    public String InsertForm(Model model, WordSet wordSet, HttpSession session){
        Member tryMember = (Member) session.getAttribute("memberSession");
        model.addAttribute("tryMember", tryMember);
        return "SearchSystem/InsertForm";
    }

    @RequestMapping(value = "Insert", method = RequestMethod.POST)
    public String Insert(WordSet wordSet){
        if(service.Register(wordSet) > 0) { // 단어 등록 성공
            return "SearchSystem/InsertOk";
        } else{
            return "SearchSystem/InsertFail";
        }
    }

    /** Delete*/
    @RequestMapping("/DeleteForm")
    public String DeleteForm(WordSet wordSet){
        return "SearchSystem/DeleteForm";
    }

    @RequestMapping(value="Delete", method = RequestMethod.POST)
    public String Delete(WordSet wordSet){
        if(service.Search(wordSet.getWordKey()) != null){ // 찾는 단어가 있을 때
            service.Remove(wordSet); // 단어 삭제
            return "SearchSystem/DeleteOk";
        }else{ // 없을 때
            return "SearchSystem/DeleteFail";
        }
    }

    /** Search */
    @RequestMapping(value = "/SearchForm")
    public String SearchForm(WordSet wordSet){
        return "SearchSystem/SearchForm";
    }

    @RequestMapping(value = "/Search", method = RequestMethod.POST)
    public String Search(Model model, WordSet wordSet){
        String key = wordSet.getWordKey();
        WordSet result = service.Search(key);
        if(result == null){
            model.addAttribute("result", null);
        }else{
            model.addAttribute("result",result);
        }
        return "SearchSystem/SearchForm";
    }
}
