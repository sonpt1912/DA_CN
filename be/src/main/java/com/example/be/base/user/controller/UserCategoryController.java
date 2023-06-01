package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.model.response.UserCategoryResponse;
import com.example.be.base.user.service.UserBrandService;
import com.example.be.base.user.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/category")
@CrossOrigin(origins = {"*"})
public class UserCategoryController {

    @Autowired
    private UserCategoryService service;

    @GetMapping("/get-all")
    public List<UserCategoryResponse> getAll() {
        return service.getAllCategory();
    }

    @GetMapping("/get-by-product/{idProduct}")
    public UserCategoryResponse getOneByProduct(@PathVariable("idProduct") long idProduct) {
        return service.getCategoryByProduct(idProduct);
    }


}
