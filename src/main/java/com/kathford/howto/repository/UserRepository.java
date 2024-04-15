package com.kathford.howto.repository;

import com.kathford.howto.custom.UserRepositoryCustom;
import com.kathford.howto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
