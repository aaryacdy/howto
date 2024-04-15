package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.AdminRepositoryCustom;
import com.kathford.howto.model.Admin;
import com.kathford.howto.util.Helper;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AdminRepositoryImpl implements AdminRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Admin findAdminByUsername(String username) {
        Session session = (Session) entityManager.getDelegate();
        Criteria criteria = session.createCriteria(Admin.class);
        criteria.add(Restrictions.eq("username", username));
        return (Admin) criteria.setMaxResults(1).uniqueResult();

        /*CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = criteriaBuilder.createQuery(Admin.class);
        Root<Admin> adminRoot = query.from(Admin.class);
        query.where("username", username);*/
    }

    @Override
    public Admin findAdminByUserRole(String role) {
        Session session = (Session) entityManager.getDelegate();
        Criteria criteria = session.createCriteria(Admin.class);
        criteria.add(Restrictions.eq("role", role));
        return (Admin) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    public boolean isUsernameAlreadyAvailable(String username) {
        if (Helper.isNullOrEmpty(username)) return true;

        String queryString = """
                select count(id) as total from tbl_admin where username = :username
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
                select count(id) as total from tbl_admin where email = :email
                """;

        Session session = (Session) entityManager.getDelegate();
        SQLQuery query = session.createSQLQuery(queryString)
                .addScalar("total", IntegerType.INSTANCE)
                .setParameter("email", email);

        Integer total = (Integer) query.uniqueResult();
        return Helper.isNotNUllAndGreaterThanZero(total);
    }
}
