package com.kathford.howto.custom;

import com.kathford.howto.model.Admin;

public interface AdminRepositoryCustom {

    Admin findAdminByUsername(String username);

    Admin findAdminByUserRole(String role);

    boolean isUsernameAlreadyAvailable(String username);

    boolean isEmailAlreadyAvailable(String email);

}
