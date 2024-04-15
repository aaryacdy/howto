package com.kathford.howto.service;

import com.kathford.howto.model.Category;
import com.kathford.howto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public boolean saveOrUpdate(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public boolean delete(Category category) {
        try {
            categoryRepository.delete(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

}
