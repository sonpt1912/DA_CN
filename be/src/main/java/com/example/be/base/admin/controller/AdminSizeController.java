package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.base.admin.service.AdminSizeService;
import com.example.be.entity.Brand;
import com.example.be.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin(origins = {"*"})
public class AdminSizeController {

    @Autowired
    private AdminSizeService service;

    @GetMapping("/get-all-size")
    public List<Size> getAll() {
        return service.getAll();
    }

}
