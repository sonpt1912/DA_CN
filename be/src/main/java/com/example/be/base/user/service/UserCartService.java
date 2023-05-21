package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserCartResponse;
import com.example.be.base.user.repository.UserCartRepository;
import com.example.be.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCartService {

    @Autowired
    private UserCartRepository repository;

    public UserCartResponse getByCustomer(long id) {
        return repository.getByCustomer(id);
    }

    public Cart getCartById(long id) {
        return repository.findCartById(id);
    }

}
