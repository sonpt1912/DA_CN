package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.model.response.UserFavoriteResponse;
import com.example.be.base.user.repository.UserBrandResponseRepository;
import com.example.be.base.user.repository.UserFavoriteResponseRepository;
import com.example.be.entity.Customer;
import com.example.be.entity.Favorite;
import com.example.be.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoriteService {

    @Autowired
    private UserFavoriteResponseRepository response;

    public List<UserFavoriteResponse> getAllFavoriteByCustomer(Customer customer) {
        return response.getAllByCustomer(customer);
    }

    public UserFavoriteResponse getOneFavoriteByCustomerAndProduct(Customer customer, Product product) {
        return response.getOneByCustomerAndProduct(customer, product);
    }


    public void saveFavorite(Favorite favorite) {
        response.save(favorite);
    }

    public void deleteFavorite(Favorite favorite) {
        response.delete(favorite);
    }

}
