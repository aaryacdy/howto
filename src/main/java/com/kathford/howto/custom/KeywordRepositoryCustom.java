package com.kathford.howto.custom;

import com.kathford.howto.model.Keyword;
import com.kathford.howto.model.Post;

import java.util.List;

public interface KeywordRepositoryCustom {

    List<Keyword> findAllKeyword();

}
