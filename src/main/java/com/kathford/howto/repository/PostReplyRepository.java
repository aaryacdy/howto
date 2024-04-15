package com.kathford.howto.repository;

import com.kathford.howto.custom.PostReplyRepositoryCustom;
import com.kathford.howto.model.PostReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReplyRepository extends JpaRepository<PostReply, Long>, PostReplyRepositoryCustom {
}
