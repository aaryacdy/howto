package com.kathford.howto.repositoryimpl;

import com.kathford.howto.custom.CategoryRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {
}
