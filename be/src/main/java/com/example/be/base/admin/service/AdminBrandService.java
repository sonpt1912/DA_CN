package com.example.be.base.admin.service;

import com.example.be.base.admin.repository.AdminBrandRepositoy;
import com.example.be.entity.Brand;
import com.example.be.entity.Color;
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

    public Brand getOneById(long id) {
        return repositoy.findBrandById(id);
    }

    public void add(Brand brand) {
        repositoy.save(brand);
    }

    public void delete(Brand brand) {
        repositoy.save(brand);
    }

    public void update(Brand brand) {
        repositoy.save(brand);

    }


}
