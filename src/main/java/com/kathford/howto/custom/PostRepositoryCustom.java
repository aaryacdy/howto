package com.kathford.howto.custom;

import com.kathford.howto.model.Post;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> findLoggedInUserPost(Long loggedInUserId);

    List<Post> searchAllPost(String keyword);

    Integer countAllPost(Long userId);

}
