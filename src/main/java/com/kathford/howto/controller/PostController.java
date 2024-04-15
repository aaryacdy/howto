package com.kathford.howto.controller;

import com.kathford.howto.model.Admin;
import com.kathford.howto.model.Category;
import com.kathford.howto.model.Post;
import com.kathford.howto.model.User;
import com.kathford.howto.service.AdminService;
import com.kathford.howto.service.CategoryService;
import com.kathford.howto.service.PostService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.MessageType;
import com.kathford.howto.util.Strings;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    Helper helper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AdminService adminService;

    @GetMapping(value = "")
    public String viewListingPost(HttpSession session, Model model, RedirectAttributes redirectAttributes,
                                  HttpServletRequest httpServletRequest) {
        //validate user login
        if (!Helper.checkUserLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        Helper.setTitle(model, "Posts");
        model.addAttribute("baseUrl", httpServletRequest.getContextPath());
        Long loggedInUserId = Helper.getLoggedInUserId(session);
        model.addAttribute("posts", postService.findAllPost(loggedInUserId));
        return "post/index";
    }

    @GetMapping(value = "add")
    public String addPost(HttpSession session, RedirectAttributes redirectAttributes, Model model,
                          HttpServletRequest request) {
        //validate user login
        if (!Helper.checkUserLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        Helper.setTitle(model, "Add Post");
        model.addAttribute("baseUrl", request.getContextPath());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "post/add";
    }

    @PostMapping(value = "save")
    public String savePost(HttpSession session, RedirectAttributes redirectAttributes,
                           @ModelAttribute Post post,
                           @RequestParam(required = false) MultipartFile attachment,
                           @RequestParam(required = false) MultipartFile documentFile,
                           @RequestParam Long categoryId) throws IOException {
        //validate user login status
        if (!Helper.checkUserLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        String title = post.getTitle();
        String description = post.getDescription();

        if (Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(description)) {
            Helper.setFlashMessage(MessageType.MESSAGE, "Please input title and description and then try again.", redirectAttributes);
            return "redirect:/post";
        }

        User user = helper.getLoggedInUser(session);
        if (user != null)
            post.setCreatedBy(user);
        else {
            Admin admin = adminService.findById(Helper.getLoggedInAdminId(session));
            post.setCreatedByAdmin(admin);
        }

        post.setCreatedDate(Helper.getCurrentDateTime());
        post.setCategory(new Category(categoryId));

        if (attachment != null && attachment.getSize() > 0) {
            String postImage = System.currentTimeMillis() + "_" + UUID.randomUUID() + "." + FilenameUtils.getExtension(attachment.getOriginalFilename());
            attachment.transferTo(new File(Strings.FILE_UPLOAD_BASE_PATH + "post/" + postImage));
            post.setImage(postImage);
        }

        if (documentFile != null && documentFile.getSize() > 0) {
            String file = System.currentTimeMillis() + "_" + UUID.randomUUID() + "." + FilenameUtils.getExtension(documentFile.getOriginalFilename());
            documentFile.transferTo(new File(Strings.FILE_UPLOAD_BASE_PATH + "post/" + file));
            post.setDocument(file);
        }

        if (postService.saveOrUpdate(post))
            Helper.setFlashMessage(MessageType.MESSAGE, Strings.SAVED_SUCCESSFULLY, redirectAttributes);
        else
            Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_SAVE, redirectAttributes);

        return "redirect:/post";
    }

    @GetMapping(value = "{id}")
    public String viewPost(HttpSession session, RedirectAttributes redirectAttributes,
                           @PathVariable Long id, Model model) {
        //validate user login status
        if (!Helper.checkUserLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        Post post = postService.findById(id);
        Helper.setTitle(model, "View Post");
        if (post != null) {
            model.addAttribute("post", post);
        } else return "redirect:/post";

        return "post/view";
    }

    @GetMapping(value = "{id}/edit")
    public String editPost(HttpSession session, RedirectAttributes redirectAttributes,
                           @PathVariable Long id, Model model) {
        //validate user login status
        if (!Helper.checkUserLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        Post post = postService.findById(id);
        Helper.setTitle(model, "Edit Post");
        if (post != null) {
            model.addAttribute("post", post);
            model.addAttribute("categories", categoryService.findAllCategory());
        } else return "redirect:/post";

        return "post/edit";
    }

    @PostMapping(value = "{id}/update")
    public String updatePost(HttpSession session, RedirectAttributes redirectAttributes,
                             @ModelAttribute Post post,
                             @PathVariable Long id,
                             @RequestParam(required = false) MultipartFile attachment,
                             @RequestParam(required = false) MultipartFile documentFile,
                             @RequestParam Long categoryId) throws IOException {

        User user = helper.getLoggedInUser(session);
        Post updatedPost = postService.findById(id);
        if (user == null) {
            Admin admin = adminService.findById(Helper.getLoggedInAdminId(session));
            updatedPost.setModifiedByAdmin(admin);
        } else updatedPost.setModifiedBy(user);

        updatedPost.setModifiedDate(Helper.getCurrentDateTime());
        updatedPost.setCategory(new Category(categoryId));
        updatedPost.setTitle(post.getTitle());
        updatedPost.setBlogUrl(post.getBlogUrl());
        updatedPost.setYoutubeUrl(post.getYoutubeUrl());
        updatedPost.setDescription(post.getDescription());
        updatedPost.setStatus(post.isStatus());

        System.out.println(attachment + " attachment");
        if (attachment != null && attachment.getSize() > 0) {
            String postImage = System.currentTimeMillis() + "_" + UUID.randomUUID() + "." + FilenameUtils.getExtension(attachment.getOriginalFilename());
            attachment.transferTo(new File(Strings.FILE_UPLOAD_BASE_PATH + "post/" + postImage));
            updatedPost.setImage(postImage);
        } else
            updatedPost.setImage(updatedPost.getImage());

        if (documentFile != null && documentFile.getSize() > 0) {
            String file = System.currentTimeMillis() + "_" + UUID.randomUUID() + "." + FilenameUtils.getExtension(documentFile.getOriginalFilename());
            documentFile.transferTo(new File(Strings.FILE_UPLOAD_BASE_PATH + "post/" + file));
            updatedPost.setDocument(file);
        } else
            updatedPost.setDocument(updatedPost.getDocument());

        if (postService.saveOrUpdate(updatedPost))
            Helper.setFlashMessage(MessageType.MESSAGE, Strings.UPDATED_SUCCESSFULLY, redirectAttributes);
        else
            Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_UPDATE, redirectAttributes);

        return "redirect:/post";
    }

    @GetMapping(value = "{id}/delete")
    public String deletePost(HttpSession session, RedirectAttributes redirectAttributes,
                             @PathVariable Long id, Model model) {
        //validate user login status
        if (!Helper.checkUserLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        Post post = postService.findById(id);
        if (post != null) {
            if (postService.deletePost(post)) {
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.DELETED_SUCCESSFULLY, redirectAttributes);
            } else
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_DELETE, redirectAttributes);
        }

        return "redirect:/post";
    }
}