package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminColorService;
import com.example.be.base.admin.service.AdminVoucherService;
import com.example.be.entity.Color;
import com.example.be.entity.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/voucher")
@CrossOrigin(origins = {"*"})
public class AdminVoucherController {

    @Autowired
    private AdminVoucherService service;

    @GetMapping("/get-all")
    public List<Voucher> getAll() {
        return service.getAll();
    }

}
