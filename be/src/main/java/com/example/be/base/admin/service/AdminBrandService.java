package com.example.be.base.admin.service;

import com.example.be.base.admin.repository.AdminBrandRepositoy;
import com.example.be.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBrandService {

    @Autowired
    private AdminBrandRepositoy repositoy;

    public List<Brand> getAll() {
        return repositoy.findAll();
    }


}
