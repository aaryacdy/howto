package com.kathford.howto.controller;

import com.kathford.howto.dto.PostReplyDTO;
import com.kathford.howto.model.Post;
import com.kathford.howto.service.PostReplyService;
import com.kathford.howto.service.PostService;
import com.kathford.howto.util.Helper;
import com.kathford.howto.util.Response;
import com.kathford.howto.util.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AskController {

    private final PostService postService;
    private final PostReplyService postReplyService;

    @PostMapping(value = "search-all-post")
    public ResponseEntity<Response> filterPostAsRequested(
            @RequestParam String keyword) {

        String message = null;
        boolean success = false;

        List<Post> posts = null;
//        Map<String, Object> map = new HashMap<>();
//        Map<Long, List<PostReplyDTO>> dataMap = new HashMap<>();
        try {
            posts = postService.searchAlLPost(keyword);
            if (!Helper.isNullOrEmpty(posts)) success = true;

            /*List<PostReplyDTO> postFeedbacks = postReplyService.findAll();
            if (!Helper.isNullOrEmpty(postFeedbacks)) {
                for (var feedback : postFeedbacks) {
                    Long postId = feedback.getPostId().longValue();
                    List<PostReplyDTO> feedbacks = dataMap.getOrDefault(postId, new ArrayList<>());
                    feedbacks.add(feedback);
                    dataMap.put(postId, feedbacks);
                }
            }*/

        } catch (Exception e) {
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
        }

        /*map.put("posts", posts);
        map.put("feedbackMap", dataMap);*/

        return new ResponseEntity<>(new Response(posts/**/, message, success), HttpStatus.OK);
    }
}
