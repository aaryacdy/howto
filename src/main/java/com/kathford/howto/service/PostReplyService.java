package com.kathford.howto.service;

import com.kathford.howto.dto.PostReplyDTO;
import com.kathford.howto.model.Keyword;
import com.kathford.howto.model.PostReply;
import com.kathford.howto.repository.PostReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostReplyService {

    private final PostReplyRepository postReplyRepository;

    public boolean saveOrUpdate(PostReply postReply) {
        try {
            postReplyRepository.save(postReply);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PostReplyDTO> findAll() {
        return postReplyRepository.findAllPostReply();
    }

}
