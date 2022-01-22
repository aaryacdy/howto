package com.kathford.howto.controller;

import com.kathford.howto.model.Admin;
import com.kathford.howto.service.AdminService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    Helper helper;

    @Autowired
    AdminService adminService;

    @GetMapping(value = "signup")
    public String viewSignUpPage(Model model, HttpServletRequest httpServletRequest) {

        Helper.setTitle(model, "Signup");
        model.addAttribute("baseUrl", httpServletRequest.getContextPath());

        return "admin/add";
    }

    @PostMapping(value = "signup")
    public String saveRegistration(RedirectAttributes redirectAttributes,
                                   @ModelAttribute Admin admin) {

        //here save code start

        try {
            if (adminService.saveOrUpdate(admin)) {
                System.out.print(" Saved successfully.");
                redirectAttributes.addFlashAttribute("message", Strings.SAVED_SUCCESSFULLY);
            } else redirectAttributes.addFlashAttribute("message", Strings.FAILED_TO_SAVE);

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", Strings.SOMETHING_WENT_WRONG);
        }

        return null;
    }

}
