package com.kathford.howto.controller;

import com.kathford.howto.util.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "post")
public class PostController {

    @GetMapping(value = "add")
    public String addPost(HttpSession session, Model model,
                          HttpServletRequest httpServletRequest) {

        Helper.setTitle(model, "Add Post");
        model.addAttribute("baseUrl", httpServletRequest.getContextPath());
        return "post/add";
    }

}
