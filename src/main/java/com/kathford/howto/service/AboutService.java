package com.kathford.howto.service;

import com.kathford.howto.model.AboutUs;
import com.kathford.howto.repository.AboutUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutService {

    @Autowired
    AboutUsRepository aboutUsRepository;

    public boolean saveOrUpdate(AboutUs aboutUs) {
        try {
            aboutUsRepository.save(aboutUs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public AboutUs findById(Long id) {
        return aboutUsRepository.findById(id).orElse(null);
    }
}
