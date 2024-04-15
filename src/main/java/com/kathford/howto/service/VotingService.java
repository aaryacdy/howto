package com.kathford.howto.service;

import com.kathford.howto.model.Voting;
import com.kathford.howto.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

    @Autowired
    VotingRepository votingRepository;

    public boolean saveOrUpdate(Voting voting) {
        try {
            votingRepository.save(voting);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Voting findById(Long id) {
        return votingRepository.findById(id).orElse(null);
    }

}
