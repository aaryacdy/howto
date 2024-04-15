package com.kathford.howto.controller;

import com.kathford.howto.service.AboutService;
import com.kathford.howto.service.PostService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class DashboardController {

    @Autowired
    AboutService aboutService;

    @Autowired
    PostService postService;

    @GetMapping(value = "admin/dashboard")
    public String viewDashboard(HttpSession session, Model model,
                                HttpServletRequest request, RedirectAttributes redirectAttributes) {
        //validate logged in status
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "Dashboard");
        model.addAttribute("baseUrl", request.getContextPath());
        model.addAttribute("totalPost", postService.countAllPost(null));

//        return "layout/dashboard/admin/dashboard";
        return "layout/dashboard/admin-v2/dashboard";
    }

    @GetMapping(value = "dashboard")
    public String viewDashboard(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                                HttpServletRequest request) {

        //validate user login status
        if (!Helper.checkUserLogin(session)) {
            redirectAttributes.addAttribute(MessageType.MESSAGE, "Please login.");
            return "redirect:/login";
        }

        Helper.setTitle(model, "Dashboard");
        model.addAttribute("baseUrl", request.getContextPath());
        model.addAttribute("totalPost", postService.countAllPost(Helper.getLoggedInUserId(session)));

//        return "user/dashboard";
        return "layout/dashboard/user/dashboard";
    }

    @GetMapping(value = "contact-us")
    public String viewContactPage(HttpServletRequest request,
                                  Model model) {

        Helper.setTitle(model, "Contact");
        model.addAttribute("baseUrl", request.getContextPath());
        model.addAttribute("aboutUs", aboutService.findById(1l));

        return "user/contact";
    }
}