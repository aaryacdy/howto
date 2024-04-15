package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.KeywordRepositoryCustom;
import com.kathford.howto.model.Keyword;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class KeywordRepositoryImpl implements KeywordRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Keyword> findAllKeyword() {
        return null;
    }
}
