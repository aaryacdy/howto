package com.kathford.howto.repository;

import com.kathford.howto.custom.VotingRepositoryCustom;
import com.kathford.howto.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepository extends JpaRepository<Voting, Long>, VotingRepositoryCustom {
}
