package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.UserRepositoryCustom;
import com.kathford.howto.model.Admin;
import com.kathford.howto.model.User;
import com.kathford.howto.util.Helper;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findAdminByUsername(String username) {
        Session session = (Session) entityManager.getDelegate();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    public boolean setUserBlockedOrUnblocked(Long id, boolean isBlocked) {
        String queryString = "update tbl_user set blocked=:isBlocked where id=:id";
        Session session = (Session) entityManager.getDelegate();
        SQLQuery query = session.createSQLQuery(queryString)
                .setParameter("id", id)
                .setParameter("isBlocked", isBlocked);
        try {
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isUsernameAlreadyAvailable(String username) {
        if (Helper.isNullOrEmpty(username)) return true;

        String queryString = """
                select count(id) as total from tbl_user where username = :username
                """;

        Session session = (Session) entityManager.getDelegate();
        SQLQuery query = session.createSQLQuery(queryString)
                .addScalar("total", IntegerType.INSTANCE)
                .setParameter("username", username);

        Integer total = (Integer) query.uniqueResult();
        return Helper.isNotNUllAndGreaterThanZero(total);
    }

    @Override
    public boolean isEmailAlreadyAvailable(String email) {
        if (Helper.isNullOrEmpty(email)) return true;

        String queryString = """
                select count(id) as total from tbl_user where email = :email
                """;

        Session session = (Session) entityManager.getDelegate();
        SQLQuery query = session.createSQLQuery(queryString)
                .addScalar("total", IntegerType.INSTANCE)
                .setParameter("email", email);

        Integer total = (Integer) query.uniqueResult();
        return Helper.isNotNUllAndGreaterThanZero(total);
    }
}
