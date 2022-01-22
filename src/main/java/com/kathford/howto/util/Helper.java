package com.kathford.howto.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class Helper {

    public static void setTitle(Model model, String title) {
        model.addAttribute("title", title);
    }

    public static boolean checkAdminLogin(HttpSession session) {
        return (session.getAttribute("admin_id") != null);
    }

    public static int getLoggedInAdminId(HttpSession session){
        return Integer.parseInt(session.getAttribute("admin_id").toString());
    }

}
