package com.kathford.howto.custom;

import com.kathford.howto.dto.PostReplyDTO;

import java.util.List;

public interface PostReplyRepositoryCustom {

    List<PostReplyDTO> findAllPostReply();

}
