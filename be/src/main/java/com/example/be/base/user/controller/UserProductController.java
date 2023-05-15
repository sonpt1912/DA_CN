package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.base.user.service.UserColorService;
import com.example.be.base.user.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {"*"})
public class UserProductController {

    @Autowired
    private UserProductService service;

    @GetMapping("/get-all")
    public List<UserProductResponse> getAll() {
        return service.getAllProduct();
    }

    @GetMapping("/get-3-new-product")
    public List<UserProductResponse> getTop3NewProduct() {
        return service.getTop3NewProduct();
    }

}
