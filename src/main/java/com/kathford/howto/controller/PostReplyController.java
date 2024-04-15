package com.kathford.howto.controller;

import com.kathford.howto.model.Post;
import com.kathford.howto.model.PostReply;
import com.kathford.howto.service.PostReplyService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "post-reply")
@AllArgsConstructor
public class PostReplyController {

    private final PostReplyService postReplyService;

    @PostMapping(value = "submit")
    public ResponseEntity<Response> savePostReply(HttpSession session,
                                                  @RequestParam Long postId,
                                                  @RequestParam(required = false) String feedback) {

        String message = null;
        var success = false;

        if (!Helper.isNullOrEmpty(feedback) && postId != null) {

            PostReply postReply = new PostReply();
            postReply.setReply(feedback);
            postReply.setPost(new Post(postId));
            success = postReplyService.saveOrUpdate(postReply);
            if (success)
                message = "Feedback submitted successfully.";
        }

        return new ResponseEntity<>(new Response(null, message, success), HttpStatus.OK);
    }

}
