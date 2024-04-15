package com.kathford.howto.service;

import com.kathford.howto.model.Post;
import com.kathford.howto.repository.PostRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public boolean saveOrUpdate(Post post) {
        try {
            postRepository.save(post);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAllPost() {
        return (List<Post>) postRepository.findAll();
    }

    public boolean deletePost(Post post) {
        try {
            postRepository.delete(post);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Post> findAllPost(Long loggedInUser) {
        return postRepository.findLoggedInUserPost(loggedInUser);
    }

    public List<Post> searchAlLPost(String keyword) {
        return postRepository.searchAllPost(keyword);
    }

    public Integer countAllPost(Long userId) {
        return postRepository.countAllPost(userId);
    }

}
