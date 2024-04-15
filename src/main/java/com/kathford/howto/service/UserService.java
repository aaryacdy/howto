package com.kathford.howto.service;

import com.kathford.howto.model.User;
import com.kathford.howto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean saveOrUpdate(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean deleteUser(User user) {
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findByUsername(String username) {
        return userRepository.findAdminByUsername(username);
    }

    public boolean isUsernameAlreadyAvailable(String username) {
        return userRepository.isUsernameAlreadyAvailable(username);
    }

    public boolean isEmailAlreadyAvailable(String email) {
        return userRepository.isEmailAlreadyAvailable(email);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public boolean blockOrUnblockedUser(Long id, boolean isBlocked) {
        return userRepository.setUserBlockedOrUnblocked(id, isBlocked);
    }

}
