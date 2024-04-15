package com.kathford.howto.unittesting;

import com.kathford.howto.model.Admin;
import com.kathford.howto.model.Category;
import com.kathford.howto.service.CategoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
public class UnitTestCategory {

    @Autowired
    CategoryService categoryService;

    public void dumyTestForCategory() {  //create function for dumy data
        for (var i = 0; i < 5000; i++) {
            Category category = new Category();
            category.setStatus(true);
            category.setCreatedBy(new Admin(1L));
            category.setCreatedDate(new Date());
            category.setName("Architecture");
            categoryService.saveOrUpdate(category);
        }
    }
}
