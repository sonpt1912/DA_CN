package com.example.be.base.admin.service;

import com.example.be.base.admin.model.response.AdminProductResponse;
import com.example.be.base.admin.repository.AdminProductRepositoy;
import com.example.be.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductService {

    @Autowired
    private AdminProductRepositoy repositoy;

    public List<Product> getAll(String name) {
        if (name.isEmpty() || name == null) {
            return repositoy.findAll();
        }
        return repositoy.findProductsByNameContaining(name);
    }

    public AdminProductResponse getOneByProduct(Product product) {
        return repositoy.getOneById(product);
    }

    public Product findById(Long id) {
        return repositoy.findById(id).get();
    }
}
