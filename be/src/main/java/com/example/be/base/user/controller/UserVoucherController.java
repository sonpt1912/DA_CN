package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.base.user.service.UserBillService;
import com.example.be.base.user.service.UserDetailCartService;
import com.example.be.base.user.service.UserVoucherService;
import com.example.be.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/user/voucher")
public class UserVoucherController {

    @Autowired
    private UserVoucherService voucherService;

    @Autowired
    private UserBillService billService;

    @GetMapping("/get-voucher-by-code/{code}")
    public UserVoucherResponse getOneByCode(@PathVariable("code") String code) {
        return voucherService.getVoucherResponseByCode(code);
    }

    @GetMapping("/get-voucher-by-bill/{id}")
    public UserVoucherResponse getOneByBill(@PathVariable("id") Long id) {
        Bill bill = billService.getOneById(id);
        return voucherService.getVoucherResponseByBill(bill);
    }
}
