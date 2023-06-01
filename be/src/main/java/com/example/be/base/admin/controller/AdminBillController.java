package com.example.be.base.admin.controller;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.base.admin.service.AdminBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/bill")
@CrossOrigin(origins = {"*"})
public class AdminBillController {

    @Autowired
    private AdminBillService service;

    @GetMapping("/get-all")
    public List<AdminBillResponse> getAll() {
        return service.getAll();
    }

}
