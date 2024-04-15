package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.VotingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class VotingRepositoryImpl implements VotingRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

}
