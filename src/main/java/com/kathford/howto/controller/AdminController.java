package com.kathford.howto.controller;

import com.kathford.howto.constant.Constant;
import com.kathford.howto.model.Admin;
import com.kathford.howto.model.User;
import com.kathford.howto.service.AdminService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.MessageType;
import com.kathford.howto.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

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
        Admin admin = adminService.findByUserRole(Constant.SUPER_USER);
        model.addAttribute("isSuperUser", admin != null);

        return "admin/add";
    }

    @PostMapping(value = "signup/save")
    public String saveRegistration(RedirectAttributes redirectAttributes,
                                   @ModelAttribute Admin admin) {

        //here save code start
        try {

            String password = admin.getPassword();
            String username = admin.getUsername();
            String email = admin.getEmail();

            if (Helper.isNullOrEmpty(username)) {
                redirectAttributes.addFlashAttribute("message", "Please enter username.");
                return "redirect:/admin/signup";
            }

            if (Helper.isNullOrEmpty(password)) {
                redirectAttributes.addFlashAttribute("message", "Please enter password.");
                return "redirect:/admin/signup";
            }

            if (adminService.isUsernameAlreadyAvailable(username)) {
                Helper.setFlashMessage(MessageType.MESSAGE, "Username is already available. Please use another username.", redirectAttributes);
                return "redirect:/admin/signup";
            }

            if (adminService.isEmailAlreadyAvailable(email)) {
                Helper.setFlashMessage(MessageType.MESSAGE, "Email is already available. Please use another email.", redirectAttributes);
                return "redirect:/admin/signup";
            }


            admin.setRole("Super User");
            String salt = UUID.randomUUID().toString().substring(0, 8);
            String concatedPwd = salt.concat(password);
            String finalRawPwd = DigestUtils.md5DigestAsHex(concatedPwd.getBytes());
            admin.setPassword(finalRawPwd);
            admin.setSalt(salt);
            admin.setPhoneNo(admin.getPhoneNo() != null ? admin.getPhoneNo() : "");
            admin.setCreatedDate(new Date());

            if (adminService.saveOrUpdate(admin)) {
                redirectAttributes.addFlashAttribute("message", Strings.SAVED_SUCCESSFULLY);
            } else redirectAttributes.addFlashAttribute("message", Strings.FAILED_TO_SAVE);

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", Strings.SOMETHING_WENT_WRONG);
        }

        return "redirect:/admin/login";
    }

    @GetMapping(value = "login")
    public String viewLoginPage(Model model, HttpServletRequest httpServletRequest) {
        //validate admin logged in status
        Helper.setTitle(model, "Login");
        model.addAttribute("baseUrl", httpServletRequest.getContextPath());
        return "login/login";
    }

    @PostMapping(value = "login/validate-login")
    public String validateLogin(RedirectAttributes redirectAttributes,
                                HttpSession session,
                                @RequestParam String username,
                                @RequestParam String password) {

        if (Helper.isNullOrEmpty(username)) {
            redirectAttributes.addAttribute("message", "Please enter username");
            return "redirect:/admin/signup";
        }

        if (Helper.isNullOrEmpty(password)) {
            redirectAttributes.addAttribute("message", "Please enter password");
            return "redirect:/admin/signup";
        }

        Admin admin = adminService.findByUsername(username);
        String redirectUrl = "redirect:/admin/login";
        if (admin != null) {
            String salt = admin.getSalt();
            String encryptedPwd = admin.getPassword();

            String rawPwd = salt.concat(password);
            String finalPwd = DigestUtils.md5DigestAsHex(rawPwd.getBytes());

            if (finalPwd.equalsIgnoreCase(encryptedPwd)) {
                Helper.setFlashMessage(MessageType.MESSAGE, "Login successfully.", redirectAttributes);
                redirectUrl = "redirect:/admin/dashboard";
                session.setAttribute("admin_username", username);
                session.setAttribute("admin_id", admin.getId());
            } else {
                Helper.setFlashMessage(MessageType.MESSAGE, "Password does not match.", redirectAttributes);
            }
        } else Helper.setFlashMessage(MessageType.MESSAGE, "Username and password does not match.", redirectAttributes);

        return redirectUrl;
    }

    @GetMapping(value = "logout")
    public String userLogout(HttpSession session) {
        //destroy the session here
        session.removeAttribute("username");
        session.removeAttribute("admin_id");

        return "redirect:/admin/login";
    }

    @GetMapping(value = "reset-password")
    public String resetPassword(HttpSession session, Model model, RedirectAttributes redirectAttributes,
                                HttpServletRequest request) {
        //validate user login status
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "Reset Password");
        model.addAttribute("baseUrl", request.getContextPath());
        return "admin/reset-password";
    }

    @PostMapping(value = "reset-password")
    public String resetPassword(HttpSession session,
                                RedirectAttributes redirectAttributes,
                                @RequestParam String oldPassword,
                                @RequestParam String newPassword,
                                @RequestParam String confirmPassword) {
        //validate user logged in status
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        if (!Helper.isNullOrEmpty(oldPassword) && !Helper.isNullOrEmpty(newPassword) && !Helper.isNullOrEmpty(confirmPassword)) {
            Admin admin = adminService.findById(Helper.getLoggedInAdminId(session));
            if(admin != null) {
                String salt = admin.getSalt();
                String encryptedPwd = admin.getPassword();
                String rawPwd = salt.concat(oldPassword);
                String finalPwd = DigestUtils.md5DigestAsHex(rawPwd.getBytes());
                if (finalPwd.equalsIgnoreCase(encryptedPwd)) {
                    if (newPassword.equalsIgnoreCase(confirmPassword)) {
                        String newSalt = UUID.randomUUID().toString().substring(0, 8);
                        String newRawPwd = newSalt.concat(newPassword);
                        String newFinalPwd = DigestUtils.md5DigestAsHex(newRawPwd.getBytes());
                        admin.setSalt(newSalt);
                        admin.setPassword(newFinalPwd);
                        admin.setModifiedDate(Helper.getCurrentDateTime());
                        if (adminService.saveOrUpdate(admin)) {
                            Helper.setFlashMessage(MessageType.MESSAGE, Strings.RESET_SUCCESSFULLY, redirectAttributes);
                        } else
                            Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_SAVE_CHANGES, redirectAttributes);
                    } else
                        Helper.setFlashMessage(MessageType.MESSAGE, "New password and confirm password does not match. Please match both and try again.", redirectAttributes);
                } else
                    Helper.setFlashMessage(MessageType.MESSAGE, "Old password does not match. Please tray again.", redirectAttributes);
            } else Helper.setFlashMessage(MessageType.MESSAGE, "Failed to reset password", redirectAttributes);
        } else
            Helper.setFlashMessage(MessageType.MESSAGE, "Please enter all the field and then try again.", redirectAttributes);

        return "redirect:/admin/reset-password";
    }
}
