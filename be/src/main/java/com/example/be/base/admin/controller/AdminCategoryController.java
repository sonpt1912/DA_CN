package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.base.admin.service.AdminCategoryService;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = {"*"})
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService service;

    @GetMapping("/get-all-category")
    public List<Category> getAll() {
        return service.getAll();
    }

}
