package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.base.admin.service.AdminColorService;
import com.example.be.entity.Brand;
import com.example.be.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/color")
@CrossOrigin(origins = {"*"})
public class AdminColorController {

    @Autowired
    private AdminColorService service;

    @GetMapping("/get-all-color")
    public List<Color> getAll() {
        return service.getAll();
    }

}
