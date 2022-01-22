package com.kathford.howto.controller;

import com.kathford.howto.util.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class OtherController {

    @GetMapping(value = "dashboard")
    public String viewDashboard(HttpSession session, Model model,
                                HttpServletRequest request) {
        //validate logged in status

        Helper.setTitle(model, "dashboard");
        model.addAttribute("baseUrl", request.getContextPath());

        return "layout/dashboard/admin/dashboard";
    }

}
