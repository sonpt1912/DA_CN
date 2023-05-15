package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.model.response.UserDetailProductResponse;
import com.example.be.base.user.repository.UserBrandResponseRepository;
import com.example.be.base.user.repository.UserDetailProductResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailProductService {

    @Autowired
    private UserDetailProductResponseRepository response;

//    public List<UserBrandResponse> getAllBrand() {
//        return response.getAllBrand();
//    }

    public UserDetailProductResponse getDetailProductByIdProduct(long id) {
        return response.getDetailProductByProduct(id);
    }

}
