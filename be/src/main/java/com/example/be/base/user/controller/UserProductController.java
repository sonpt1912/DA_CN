package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.base.user.service.UserColorService;
import com.example.be.base.user.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/product")
@CrossOrigin(origins = {"*"})
public class UserProductController {

    @Autowired
    private UserProductService service;

    @GetMapping("/get-all")
    public List<UserProductResponse> getAll(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber) {
        List<UserProductResponse> listProductResponse = service.getAllProductPageable(pageNumber);
        return listProductResponse;
    }

    @GetMapping("/get-total-pages")
    public Integer getTotalPages() {
        int page = (int) Math.ceil(service.getTotalPages().size() / 1) - 1;
        return page;
    }

    @GetMapping("/get-3-new-product")
    public List<UserProductResponse> getTop3NewProduct() {
        return service.getTop3NewProduct();
    }

}
