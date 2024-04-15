package com.kathford.howto.controller;

import com.kathford.howto.model.Category;
import com.kathford.howto.repository.CategoryRepository;
import com.kathford.howto.service.CategoryService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.MessageType;
import com.kathford.howto.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    Helper helper;

    @GetMapping(value = "")
    public String viewCategory(HttpSession session, Model model,
                               HttpServletRequest request, RedirectAttributes redirectAttributes) {

        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "Categories");
        model.addAttribute("baseUrl", request.getContextPath());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "category/index";
    }

    @GetMapping(value = "add")
    public String addCategory(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes,
                              Model model) {

        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "Add Category");
        model.addAttribute("baseUrl", request.getContextPath());

        return "category/add";
    }

    @PostMapping(value = "save-update")
    public String saveCategory(HttpSession session, RedirectAttributes redirectAttributes,
                               @ModelAttribute Category category) {

        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        boolean hasCategory = category.getId() != null;

        try {

            category.setCreatedDate(Helper.getCurrentDateTime());
            category.setCreatedBy(helper.getLoggedInAdmin(session));
            if (categoryService.saveOrUpdate(category))
                Helper.setFlashMessage(MessageType.MESSAGE, hasCategory ? Strings.UPDATED_SUCCESSFULLY : Strings.SAVED_SUCCESSFULLY, redirectAttributes);
            else Helper.setFlashMessage(MessageType.MESSAGE, hasCategory ? Strings.FAILED_TO_UPDATE : Strings.FAILED_TO_SAVE, redirectAttributes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/category";
    }

    @GetMapping(value = "{id}/edit")
    public String editCategory(HttpSession session, Model model,
                               @PathVariable Long id,
                               RedirectAttributes redirectAttributes) {


        //validate admin logged in status
        if (!Helper.checkAdminLogin(session)) return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "Edit Category");
        Category category = categoryService.findById(id);

        if (category == null) {
            Helper.setFlashMessage(MessageType.MESSAGE, "Link broken", redirectAttributes);
            return "redirect:/category";
        }
        model.addAttribute("category", category);

        return "category/add";
    }

    @GetMapping(value = "{id}/delete")
    public String deleteCategory(HttpSession session, RedirectAttributes redirectAttributes,
                                 @PathVariable Long id) {

        //validate admin logged in stutus
        if (!Helper.checkAdminLogin(session)) return Helper.redirectToAdminLogin(redirectAttributes);

        try {
            Category category = categoryService.findById(id);
            if (categoryService.delete(category)) {
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.DELETED_SUCCESSFULLY, redirectAttributes);
            } else {
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_DELETE, redirectAttributes);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Helper.setFlashMessage(MessageType.ERROR, Strings.SOMETHING_WENT_WRONG, redirectAttributes);
        }

        return "redirect:/category";
    }

}
