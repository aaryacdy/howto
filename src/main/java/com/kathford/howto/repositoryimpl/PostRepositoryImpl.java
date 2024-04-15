package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.PostRepositoryCustom;
import com.kathford.howto.model.Post;
import com.kathford.howto.util.Helper;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.OrderBy;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.transform.Transformer;
import java.util.List;

@Repository
@Transactional
public class PostRepositoryImpl implements PostRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> findLoggedInUserPost(Long loggedInUserId) {
        boolean hasUserId = loggedInUserId != null && loggedInUserId > 0;
        Session session = (Session) entityManager.getDelegate();
        Criteria criteria = session.createCriteria(Post.class)
                .addOrder(Order.desc("createdDate"));
        if (hasUserId)
            criteria.add(Restrictions.eq("createdBy.id", loggedInUserId));

        return criteria.list();
    }

    @Override
    public List<Post> searchAllPost(String keyword) {
        var hasKeyword = !Helper.isNullOrEmpty(keyword);
        var queryString = "select * from tbl_post where post_status='Approve' ";
        if (hasKeyword) queryString += "and title like :keyword ";
        else queryString += "limit 8";
        var session = (Session) entityManager.getDelegate();
        var query = session.createSQLQuery(queryString)
                .addEntity(Post.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if (hasKeyword) query.setParameter("keyword", "%" + keyword + "%");
        return query.list();
    }

    @Override
    public Integer countAllPost(Long userId) {
        boolean hasUserId = Helper.isNotNUllAndGreaterThanZero(userId);
        var queryString = """
                select count(distinct id) as total from tbl_post
                """;
        if (hasUserId) queryString += "where created_by=:userId";

        Session session = (Session) entityManager.getDelegate();
        SQLQuery query = session.createSQLQuery(queryString)
                .addScalar("total", IntegerType.INSTANCE);
        if (hasUserId) query.setParameter("userId", userId);
        return (Integer) query.uniqueResult();
    }
}
