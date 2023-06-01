package com.example.be.base.admin.service;

import com.example.be.base.admin.repository.AdminSizeRepositoy;
import com.example.be.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSizeService {

    @Autowired
    private AdminSizeRepositoy repositoy;

    public List<Size> getAll() {
        return repositoy.findAll();
    }

    public Size getOneById(long id) {
        return repositoy.findSizeById(id);
    }

    public void add(Size size) {
        repositoy.save(size);
    }

    public void delete(Size size) {
        repositoy.save(size);
    }

    public void update(Size size) {
        repositoy.save(size);

    }

}
