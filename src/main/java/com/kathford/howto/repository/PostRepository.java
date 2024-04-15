package com.kathford.howto.repository;

import com.kathford.howto.custom.PostRepositoryCustom;
import com.kathford.howto.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>, PostRepositoryCustom {
}
