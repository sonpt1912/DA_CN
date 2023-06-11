package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBillService;
import com.example.be.base.admin.service.AdminColorService;
import com.example.be.base.admin.service.AdminVoucherService;
import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.entity.Bill;
import com.example.be.entity.Color;
import com.example.be.entity.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/voucher")
@CrossOrigin(origins = {"*"})
public class AdminVoucherController {

    @Autowired
    private AdminVoucherService voucherService;

    @Autowired
    private AdminBillService billService;

    @GetMapping("/get-all")
    public List<Voucher> getAll() {
        return voucherService.getAll();
    }

    @GetMapping("/get-voucher-by-bill/{id}")
    public Voucher getOneByBill(@PathVariable("id") Long id) {
        Bill bill = billService.findOneById(id);
        return voucherService.getVoucherResponseByBill(bill);
    }

}
