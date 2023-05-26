package com.example.be.base.admin.service;

import com.example.be.base.admin.repository.AdminBrandRepositoy;
import com.example.be.base.admin.repository.AdminCategoryRepositoy;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
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


}
