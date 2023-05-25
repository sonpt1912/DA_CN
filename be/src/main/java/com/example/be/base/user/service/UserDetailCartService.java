package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserDetailCartResponse;
import com.example.be.base.user.repository.UserDetailCartRepository;
import com.example.be.entity.Cart;
import com.example.be.entity.DetailCart;
import com.example.be.entity.DetailCartId;
import com.example.be.entity.DetailProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailCartService {

    @Autowired
    private UserDetailCartRepository detailCartRepository;


    public List<UserDetailCartResponse> getAllUserDetailCartByCart(long id) {
        return detailCartRepository.getAllByCart(id);
    }

    public DetailCart getDetailCart(Cart cart, DetailProduct detailProduct) {
        return detailCartRepository.findDetailCartByCartAndAndDetailProduct(cart, detailProduct);
    }


    public void deleteDetailCart(DetailCart detailCart) {
        detailCartRepository.delete(detailCart);
    }

    public void saveDetailCart(DetailCart detailCart) {
        detailCartRepository.save(detailCart);
    }

}
