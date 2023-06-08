package com.example.be.base.user.controller;

import com.example.be.base.user.model.request.UserCustomerRequest;
import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.model.response.UserCustomerResponse;
import com.example.be.base.user.service.UserColorService;
import com.example.be.base.user.service.UserCustomerService;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/customer")
@CrossOrigin(origins = {"*"})
public class UserCustomerController {

    @Autowired
    private UserCustomerService service;

    @GetMapping("/get-one-by-id/{id}")
    public UserCustomerResponse getOneById(@PathVariable("id") long id) {
        return service.getCustomerResponseById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UserCustomerRequest userCustomerRequest) {
        Customer customer = service.getOneById(userCustomerRequest.getId());

        customer.setEmail(userCustomerRequest.getEmail());
        customer.setFirstName(userCustomerRequest.getFirstName());
        customer.setLastName(userCustomerRequest.getLastName());
        customer.setPhoneNumber(userCustomerRequest.getPhoneNumber());
        service.update(customer);
    }
}
