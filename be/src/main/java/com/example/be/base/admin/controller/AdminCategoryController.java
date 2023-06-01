package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.base.admin.service.AdminCategoryService;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
import com.example.be.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@CrossOrigin(origins = {"*"})
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService service;

    @GetMapping("/get-all-category")
    public List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Category getOneById(@PathVariable("id") long id) {
        return service.getOneById(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam String name) {
        Category category = Category.builder()
                .name(name)
                .status(0)
                .build();
        service.add(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        Category category = service.getOneById(id);
        category.setStatus(1);
        service.delete(category);
    }

    @PutMapping("/update")
    public void update(@ModelAttribute Category category) {
        service.update(category);
    }
}
