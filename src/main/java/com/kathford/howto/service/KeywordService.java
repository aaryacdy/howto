package com.kathford.howto.service;

import com.kathford.howto.model.AboutUs;
import com.kathford.howto.model.Keyword;
import com.kathford.howto.repository.AboutUsRepository;
import com.kathford.howto.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
    @Autowired
    KeywordRepository keywordRepository;

    public boolean saveOrUpdate(Keyword keyword) {
        try {
            keywordRepository.save(keyword);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Keyword> findAll() {
        return keywordRepository.findAll();
    }

}
