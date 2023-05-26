package com.example.be.base.admin.controller;

import com.example.be.base.admin.repository.AdminProductRepositoy;
import com.example.be.base.admin.service.AdminProductService;
import com.example.be.base.admin.service.AdminSizeService;
import com.example.be.entity.Product;
import com.example.be.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {"*"})
public class AdminProductController {

    @Autowired
    private AdminProductService service;

    @GetMapping("/get-all-product")
    public List<Product> getAll() {
        return service.getAll();
    }

}
