package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserCategoryResponse;
import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.service.UserCategoryService;
import com.example.be.base.user.service.UserColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/color")
@CrossOrigin(origins = {"*"})
public class UserColorController {

    @Autowired
    private UserColorService service;

    @GetMapping("/get-all")
    public List<UserColorResponse> getAll() {
        return service.getAllColor();
    }

    @GetMapping("/get-by-product/{idProduct}")
    public List<UserColorResponse> getOneByProduct(@PathVariable("idProduct") long idProduct) {
        return service.getColorByProduct(idProduct);
    }

}
