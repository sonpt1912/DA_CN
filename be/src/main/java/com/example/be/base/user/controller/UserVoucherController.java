package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.base.user.service.UserDetailCartService;
import com.example.be.base.user.service.UserVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/voucher")
public class UserVoucherController {

    @Autowired
    private UserVoucherService service;

    @GetMapping("/get-voucher-by-code/{code}")
    public UserVoucherResponse getOneByCode(@PathVariable("code") String code) {
        return service.getVoucherByCode(code);
    }

}
