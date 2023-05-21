package com.example.be.base.user.controller;

import com.example.be.base.user.model.request.UserDetailProductRequest;
import com.example.be.base.user.model.response.UserCartResponse;
import com.example.be.base.user.service.UserCartService;
import com.example.be.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = {"*"})
public class UserCartController {


    @Autowired
    private UserCartService service;

    @GetMapping("/get-cart-by-customer/{idCustomer}")
    public UserCartResponse getCartByCustomer(@PathVariable("idCustomer") long idCustomer) {
        return service.getByCustomer(idCustomer);
    }

}
