package com.example.be.base.admin.controller;

import com.example.be.base.admin.model.response.AdminProductResponse;
import com.example.be.base.admin.service.AdminProductService;
import com.example.be.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
@CrossOrigin(origins = {"*"})
public class AdminProductController {

    @Autowired
    private AdminProductService service;

    @GetMapping("/get-all-product")
    public List<Product> getAll(@RequestParam("name") String name) {
        return service.getAll(name);
    }

    @GetMapping("/get-response/{id}")
    public AdminProductResponse getOneResponse(@PathVariable("id") Long id) {
        Product product = service.findById(id);
        return service.getOneByProduct(product);
    }

}
