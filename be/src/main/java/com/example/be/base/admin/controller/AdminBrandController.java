package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = {"*"})
public class AdminBrandController {

    @Autowired
    private AdminBrandService service;

    @GetMapping("/get-all-brand")
    public List<Brand> getAll() {
        return service.getAll();
    }

}
