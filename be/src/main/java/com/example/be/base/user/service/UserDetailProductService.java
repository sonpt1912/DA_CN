package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserDetailProductResponse;
import com.example.be.base.user.repository.UserDetailProductRepository;
import com.example.be.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailProductService {

    @Autowired
    private UserDetailProductRepository response;

    public UserDetailProductResponse getDetailProductByIdProduct(long id) {
        return response.getDetailProductByProduct(id);
    }

    public DetailProduct getDetailProductById(long id) {
        return response.findDetailProductById(id);
    }

    public DetailProduct findDetailProductByBrandAndColorAndCategoryAndSizeAndProduct(Brand brand, Color color, Category category, Size size, Product product) {
        return response.findDetailProductByBrandAndColorAndCategoryAndSizeAndProduct(brand, color, category, size, product);
    }


}
