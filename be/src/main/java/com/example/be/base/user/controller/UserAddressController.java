package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserAddressResponse;
import com.example.be.base.user.service.UserAddressService;
import com.example.be.base.user.service.UserCustomerService;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/address")
public class UserAddressController {

    @Autowired
    private UserAddressService addressService;

    @Autowired
    private UserCustomerService customerService;


    @GetMapping("/get-all-address-by-customer/{idCustomer}")
    public List<UserAddressResponse> getAllByCustomer(@PathVariable("idCustomer") long idCustomer) {
        Customer customer = customerService.findCustomerById(idCustomer);
        return addressService.getAddressByCustomer(customer);
    }

    @GetMapping("/get-by-id/{idAddress}")
    public UserAddressResponse getOneById(@PathVariable("idAddress") long idAddress) {
        return addressService.getOneById(idAddress);
    }

}
