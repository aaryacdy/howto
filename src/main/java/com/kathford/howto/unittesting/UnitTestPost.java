package com.kathford.howto.unittesting;

import com.kathford.howto.model.Category;
import com.kathford.howto.model.Post;
import com.kathford.howto.model.User;
import com.kathford.howto.service.PostService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
public class UnitTestPost {

    @Autowired
    PostService postService;

    public void dumyTestForPost() {  //create function for dumy data
        for (var i = 0; i < 5000; i++) {
            var content = """
                    i. You sign in to YouTube with your Google Account.
                     To sign in to YouTube, enter your Google Account email and password.
                     After signing up for YouTube, signing in to your Google account on another Google
                     service will automatically sign you in to YouTube.
                    ii. Deleting your Google Account will delete your YouTube data, including all videos, 
                     comments, and subscriptions. Before deleting your Google Account, 
                     you'll have to confirm that you understand you're permanently deleting your data on all Google 
                     services, including YouTube.
                    """;

            Post post = new Post();
            post.setTitle("How to use youtube ?");
            post.setDescription(content);
            post.setPostStatus("Approved");
            post.setCategory(new Category(1L));
            post.setCreatedBy(new User(1L));
            post.setCreatedDate(new Date());
            post.setBlogUrl("https://support.google.com/youtube/answer/69961?hl=en");
            post.setYoutubeUrl("xkwUuCuXLoU");
            postService.saveOrUpdate(post);
        }
    }
}
