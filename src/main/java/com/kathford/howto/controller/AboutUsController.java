package com.kathford.howto.controller;

import com.kathford.howto.model.AboutUs;
import com.kathford.howto.service.AboutService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.MessageType;
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
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "about-us")
public class AboutUsController {

    @Autowired
    AboutService aboutService;

    @GetMapping(value = "")
    public String addAboutUs(RedirectAttributes redirectAttributes, Model model,
                             HttpServletRequest request, HttpSession session) {

        //validate admin logged in status
       // if(Helper.checkAdminLogin(session))
           // return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "About Us");
        model.addAttribute("aboutUs", aboutService.findById(1l));
        model.addAttribute("baseUrl", request.getContextPath());

        return "about-us/message";
    }

    @PostMapping(value = "save-update")
    public String saveOrUpdate(@ModelAttribute AboutUs aboutUs, HttpSession session,
                               RedirectAttributes redirectAttributes) {
        //validate admin logged in status
//        if(Helper.checkAdminLogin(session))
//            return Helper.redirectToAdminLogin(redirectAttributes);

        Long id = aboutUs.getId();
        boolean isUpdate = id != null;
        if (isUpdate) aboutUs.setId(id);
        if (aboutService.saveOrUpdate(aboutUs))
            Helper.setFlashMessage(MessageType.MESSAGE, isUpdate ?
                    Strings.UPDATED_SUCCESSFULLY : Strings.SAVED_SUCCESSFULLY, redirectAttributes);
        else
            Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_SAVE_CHANGES, redirectAttributes);

        return "redirect:/about-us";

    }
}
