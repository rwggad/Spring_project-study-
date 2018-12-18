package conn.controller;

import conn.Model.LoginModel.Member;
import conn.Model.WordModel.WordSet;
import conn.service.WordService.WordService;
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
    public String Home(WordSet wordSet){
        return "SearchSystem/HomeForm";
    }

    /** Search */
    @RequestMapping(value = "/Search", method = RequestMethod.POST)
    public String Search(Model model, WordSet wordSet){
        WordSet selectWord = service.Search(wordSet.getWordKey()); // 단어를 가져옴
        if(selectWord != null){ // 단어가 있다면
            List<WordSet> wordList = new ArrayList<WordSet>(); // List 형태로 반환
            wordList.add(service.Search(wordSet.getWordKey())); // Model에 추가
            model.addAttribute("wordList",wordList);
        }else{
            model.addAttribute("wordList", null);
        }
        return "SearchSystem/HomeForm";
    }

    @RequestMapping(value = "/AllSearch", method = RequestMethod.POST)
    public String AllSearch(Model model, WordSet wordSet){
        List<WordSet> wordList = service.SearchAll(); // 전체 단어 가져옴
        model.addAttribute("wordList",wordList); // List형태로 전달
        return "SearchSystem/HomeForm";
    }

    /** insert */
    @RequestMapping("/InsertForm")
    public String InsertForm(Model model, WordSet wordSet, HttpSession session){
        Member tryMember = (Member) session.getAttribute("memberSession"); // 회원 정보 세션들고온다.
        model.addAttribute("tryMember", tryMember); // 단어를 등록하려는 회원 정보를 model에 담아서 전달
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
}
