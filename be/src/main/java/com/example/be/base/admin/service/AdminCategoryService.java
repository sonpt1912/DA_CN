package com.example.be.base.admin.service;

import com.example.be.base.admin.repository.AdminBrandRepositoy;
import com.example.be.base.admin.repository.AdminCategoryRepositoy;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
import com.example.be.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCategoryService {

    @Autowired
    private AdminCategoryRepositoy repositoy;

    public List<Category> getAll() {
        return repositoy.findAll();
    }

    public Category getOneById(long id) {
        return repositoy.findCategoryById(id);
    }

    public void add(Category category) {
        repositoy.save(category);
    }

    public void delete(Category category) {
        repositoy.save(category);
    }

    public void update(Category category) {
        repositoy.save(category);

    }

}
