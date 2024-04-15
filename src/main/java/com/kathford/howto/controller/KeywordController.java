package com.kathford.howto.controller;

import com.kathford.howto.model.Keyword;
import com.kathford.howto.service.KeywordService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "keyword")
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    @GetMapping(value = "admin")
    public String adminAllKeyword(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        //validate user login status
        if (!Helper.checkUserLogin(session)) return Helper.redirectToUserLogin(redirectAttributes);

        Helper.setTitle(model, "All Asked questions");
        model.addAttribute("keywords", keywordService.findAll());
        return "keyword/admin-all-keyword";
    }

    @GetMapping(value = "")
    public String viewAllKeyword(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        //validate user login status
        if (!Helper.checkUserLogin(session)) return Helper.redirectToUserLogin(redirectAttributes);

        Helper.setTitle(model, "All Asked questions");
        model.addAttribute("keywords", keywordService.findAll());
        return "keyword/all-keyword";
    }

    @PostMapping(value = "save")
    public ResponseEntity<Response> saveKeyword(@RequestParam(required = false) String keyword) {
        var success = false;
        if (!Helper.isNullOrEmpty(keyword)) {
            Keyword saveKeyword = new Keyword();
            var howTo = "How to";
            var hasHowTo = keyword.contains(howTo);
            var question = hasHowTo || keyword.contains("how to") ? keyword : "How to " + keyword;
            saveKeyword.setQuestions(question);
            success = keywordService.saveOrUpdate(saveKeyword);
        }

        return new ResponseEntity<>(new Response(null, null, success), HttpStatus.OK);
    }
}
