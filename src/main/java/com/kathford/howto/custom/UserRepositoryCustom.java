package com.kathford.howto.custom;

import com.kathford.howto.model.Admin;
import com.kathford.howto.model.User;

public interface UserRepositoryCustom {

    User findAdminByUsername(String username);

    boolean setUserBlockedOrUnblocked(Long id, boolean isBlocked);

    boolean isUsernameAlreadyAvailable(String username);

    boolean isEmailAlreadyAvailable(String email);

}
