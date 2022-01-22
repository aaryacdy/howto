package com.kathford.howto.controller;

import com.kathford.howto.service.AdminService;
import com.kathford.howto.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin/login")
public class LoginController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "")
    public String viewLoginPage(Model model, HttpServletRequest httpServletRequest) {
        //validate admin logged in status
        Helper.setTitle(model, "Login");
        model.addAttribute("baseUrl", httpServletRequest.getContextPath());
        return "login/login";
    }

    @PostMapping(value = "")
    public String validateLogin(RedirectAttributes redirectAttributes,
                                @RequestParam String username,
                                @RequestParam String password) {

        return null;
    }

}
