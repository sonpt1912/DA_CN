package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.model.response.UserSizeResponse;
import com.example.be.base.user.repository.UserBrandResponseRepository;
import com.example.be.base.user.repository.UserSizeResponseRepository;
import com.example.be.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBrandService {

    @Autowired
    private UserBrandResponseRepository response;

    public List<UserBrandResponse> getAllBrand() {
        return response.getAllBrand();
    }

    public UserBrandResponse getBrandByProduct(long idProduct) {
        return response.getBrandByIdProduct(idProduct);
    }

}
