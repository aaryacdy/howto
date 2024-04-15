package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.PostReplyRepositoryCustom;
import com.kathford.howto.dto.PostReplyDTO;
import com.kathford.howto.model.Post;
import com.kathford.howto.util.Helper;
import lombok.experimental.Delegate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostReplyRepositoryImpl implements PostReplyRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<PostReplyDTO> findAllPostReply() {
        var queryString = "select post_id AS postId, reply AS feedback from tbl_post_reply ";
        var session = (Session) entityManager.getDelegate();
        var query = session.createSQLQuery(queryString)
                .setResultTransformer(Transformers.aliasToBean(PostReplyDTO.class));
        return query.list();
    }
}
