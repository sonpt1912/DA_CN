package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.model.response.UserCustomerResponse;
import com.example.be.base.user.service.UserColorService;
import com.example.be.base.user.service.UserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = {"*"})
public class UserCustomerController {

    @Autowired
    private UserCustomerService service;

    @GetMapping("/get-one-by-id/{id}")
    public UserCustomerResponse getOneById(@PathVariable("id") long id) {
        return service.getCustomerResponseById(id);
    }


}
