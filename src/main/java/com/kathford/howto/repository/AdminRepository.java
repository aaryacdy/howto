package com.kathford.howto.repository;

import com.kathford.howto.custom.AdminRepositoryCustom;
import com.kathford.howto.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>, AdminRepositoryCustom {
}
