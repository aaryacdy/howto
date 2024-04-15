package com.kathford.howto.util;

import com.kathford.howto.model.Admin;
import com.kathford.howto.model.User;
import com.kathford.howto.repository.AdminRepository;
import com.kathford.howto.service.AdminService;
import com.kathford.howto.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class Helper {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    public static void setTitle(Model model, String title) {
        model.addAttribute("title", title);
    }

    public static boolean checkAdminLogin(HttpSession session) {
        return (session.getAttribute("admin_id") != null);
    }

    public static boolean checkUserLogin(HttpSession session) {
        return (session.getAttribute("username") != null && session.getAttribute("username") != "");
    }

    public static Long getLoggedInUserId(HttpSession session) {
        return session.getAttribute("user_id") != null ? Long.parseLong(session.getAttribute("user_id").toString()) : 0l;
    }

    public User getLoggedInUser(HttpSession session) {
        return userService.findById(Helper.getLoggedInUserId(session));
    }

    public static Long getLoggedInAdminId(HttpSession session) {
        return session.getAttribute("admin_id") != null ? Long.parseLong(session.getAttribute("admin_id").toString()) : 0l;
    }

    public Admin getLoggedInAdmin(HttpSession session) {
        return adminService.findById(Helper.getLoggedInAdminId(session));
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isNullOrEmpty(List<?> value) {
        return value == null || value.isEmpty();
    }

    public static void setFlashMessage(String messageType, String message, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(messageType, message);
    }

    public static String redirectToUserLogin(RedirectAttributes redirectAttributes) {
        //validate user login status
        redirectAttributes.addFlashAttribute(MessageType.MESSAGE, "Please login.");
        return "redirect:/login";
    }

    public static String redirectToAdminLogin(RedirectAttributes redirectAttributes) {
        //validate user login status
        redirectAttributes.addFlashAttribute(MessageType.MESSAGE, "Please login.");
        return "redirect:/admin/login";
    }

    public static Date getCurrentDateTime() {
        return new Date();
    }

    public static boolean isNotNUllAndGreaterThanZero(Long value) {
        return value != null && value > 0;
    }

    public static boolean isNotNUllAndGreaterThanZero(Integer value) {
        return value != null && value > 0;
    }
}
