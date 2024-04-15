package com.kathford.howto.controller;

import com.kathford.howto.model.Admin;
import com.kathford.howto.model.Category;
import com.kathford.howto.model.Post;
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
@RequestMapping(value = "admin/post")
public class AdminPostController {

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
        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Helper.setTitle(model, "Posts");
        model.addAttribute("baseUrl", httpServletRequest.getContextPath());
        model.addAttribute("posts", postService.findAllPost(null));
        return "admin-post/index";
    }

    @GetMapping(value = "add")
    public String addPost(HttpSession session, RedirectAttributes redirectAttributes, Model model,
                          HttpServletRequest request) {
        //validate user login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToUserLogin(redirectAttributes);

        Helper.setTitle(model, "Add Post");
        model.addAttribute("baseUrl", request.getContextPath());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "admin-post/add";
    }

    @PostMapping(value = "save")
    public String savePost(HttpSession session, RedirectAttributes redirectAttributes,
                           @ModelAttribute Post post,
                           @RequestParam(required = false) MultipartFile attachment,
                           @RequestParam(required = false) MultipartFile documentFile,
                           @RequestParam Long categoryId) throws IOException {
        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Admin admin = adminService.findById(Helper.getLoggedInAdminId(session));
        post.setCreatedByAdmin(admin);

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

        return "redirect:/admin/post";
    }

    @GetMapping(value = "{id}")
    public String viewPost(HttpSession session, RedirectAttributes redirectAttributes,
                           @PathVariable Long id, Model model) {
        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Post post = postService.findById(id);
        Helper.setTitle(model, "View Post");
        if (post != null) {
            model.addAttribute("post", post);
        } else return "redirect:/post";

        return "admin-post/view";
    }

    @GetMapping(value = "{id}/edit")
    public String editPost(HttpSession session, RedirectAttributes redirectAttributes,
                           @PathVariable Long id, Model model) {
        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Post post = postService.findById(id);
        Helper.setTitle(model, "Edit Post");
        if (post != null) {
            model.addAttribute("post", post);
            model.addAttribute("categories", categoryService.findAllCategory());
        } else return "redirect:/post";

        return "admin-post/edit";
    }

    @PostMapping(value = "{id}/update")
    public String updatePost(HttpSession session, RedirectAttributes redirectAttributes,
                             @ModelAttribute Post post,
                             @PathVariable Long id,
                             @RequestParam(required = false) MultipartFile attachment,
                             @RequestParam(required = false) MultipartFile documentFile,
                             @RequestParam Long categoryId) throws IOException {
        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Post updatedPost = postService.findById(id);
        Admin admin = adminService.findById(Helper.getLoggedInAdminId(session));
        updatedPost.setModifiedByAdmin(admin);

        updatedPost.setModifiedDate(Helper.getCurrentDateTime());
        updatedPost.setCategory(new Category(categoryId));
        updatedPost.setTitle(post.getTitle());
        updatedPost.setBlogUrl(post.getBlogUrl());
        updatedPost.setYoutubeUrl(post.getYoutubeUrl());
        updatedPost.setDescription(post.getDescription());
        updatedPost.setStatus(post.isStatus());

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

        return "redirect:/admin/post";
    }

    @GetMapping(value = "{id}/delete")
    public String deletePost(HttpSession session, RedirectAttributes redirectAttributes,
                             @PathVariable Long id) {
        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Post post = postService.findById(id);
        if (post != null) {
            if (postService.deletePost(post)) {
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.DELETED_SUCCESSFULLY, redirectAttributes);
            } else
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_DELETE, redirectAttributes);
        }

        return "redirect:/admin/post";
    }

    @GetMapping(value = "{id}/approve")
    public String approvePost(@PathVariable Long id,
                              HttpSession session, RedirectAttributes redirectAttributes) {

        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Post post = postService.findById(id);
        if (post != null) {
            post.setPostStatus("Approve");
            if (postService.saveOrUpdate(post)) {
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.APPROVED_SUCCESSFULLY, redirectAttributes);
            } else
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_APPROVE, redirectAttributes);
        }

        return "redirect:/admin/post";
    }

    @GetMapping(value = "{id}/reject")
    public String rejectPost(@PathVariable Long id,
                             HttpSession session, RedirectAttributes redirectAttributes) {

        //validate admin login
        if (!Helper.checkAdminLogin(session))
            return Helper.redirectToAdminLogin(redirectAttributes);

        Post post = postService.findById(id);
        if (post != null) {
            post.setPostStatus("Rejected");
            if (postService.saveOrUpdate(post))
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.REJECTED_SUCCESSFULLY, redirectAttributes);
            else
                Helper.setFlashMessage(MessageType.MESSAGE, Strings.FAILED_TO_REJECT, redirectAttributes);
        }

        return "redirect:/admin/post";
    }

}
