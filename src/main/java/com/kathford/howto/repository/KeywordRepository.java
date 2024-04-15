package com.kathford.howto.repository;

import com.kathford.howto.custom.KeywordRepositoryCustom;
import com.kathford.howto.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long>, KeywordRepositoryCustom {
}
