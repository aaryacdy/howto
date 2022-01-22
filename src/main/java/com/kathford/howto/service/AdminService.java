package com.kathford.howto.service;

import com.kathford.howto.model.Admin;
import com.kathford.howto.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public boolean saveOrUpdate(Admin admin) {
        try {
            adminRepository.save(admin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

}
