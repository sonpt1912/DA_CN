package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.base.user.repository.UserProductRepository;
import com.example.be.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductService {

    @Autowired
    private UserProductRepository response;

    public List<UserProductResponse> getAllProduct() {
        return response.getAllProduct();
    }

    public List<UserProductResponse> getTop3NewProduct() {
        return response.getTop3NewProduct();
    }

    public Product findProductById(long id) {
        return response.findById(id).get();
    }

    ;

}
