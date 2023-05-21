package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.repository.UserBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBrandService {

    @Autowired
    private UserBrandRepository response;

    public List<UserBrandResponse> getAllBrand() {
        return response.getAllBrand();
    }

    public UserBrandResponse getBrandByProduct(long idProduct) {
        return response.getBrandByIdProduct(idProduct);
    }

}
