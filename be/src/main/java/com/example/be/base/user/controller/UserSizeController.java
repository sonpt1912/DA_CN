package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserSizeResponse;
import com.example.be.base.user.service.UserSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin(origins = {"*"})
public class UserSizeController {

    @Autowired
    private UserSizeService service;

    @GetMapping("/get-all")
    public List<UserSizeResponse> getAll() {
        return service.getAllSize();
    }

    @GetMapping("/get-by-product/{idProduct}")
    public List<UserSizeResponse> getOneByProduct(@PathVariable("idProduct") long idProduct) {
        return service.getSizeByProduct(idProduct);
    }


}
