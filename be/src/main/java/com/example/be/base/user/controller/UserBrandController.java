package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.service.UserBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = {"*"})
public class UserBrandController {

    @Autowired
    private UserBrandService service;

    @GetMapping("/get-all")
    public List<UserBrandResponse> getAll() {
        return service.getAllBrand();
    }

    @GetMapping("/get-by-product/{idProduct}")
    public UserBrandResponse getOneByProduct(@PathVariable("idProduct") long idProduct) {
        return service.getBrandByProduct(idProduct);
    }

}
