package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserDetailCartResponse;
import com.example.be.base.user.model.response.UserDetailProductResponse;
import com.example.be.base.user.service.UserCartService;
import com.example.be.base.user.service.UserDetailCartService;
import com.example.be.base.user.service.UserDetailProductService;
import com.example.be.entity.Cart;
import com.example.be.entity.DetailProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail-cart")
@CrossOrigin(origins = {"*"})
public class UserDetailCartController {

    @Autowired
    private UserDetailCartService detailCartService;

    @Autowired
    private UserCartService cartService;

    @Autowired
    private UserDetailProductService detailProductService;

    @GetMapping("/get-by-product/{IdCart}")
    public List<UserDetailCartResponse> getOneById(@PathVariable("IdCart") long id) {
        return detailCartService.getAllUserDetailCartByCart(id);
    }

    @GetMapping("/delete-detail-cart/{IdCart}/{IdDetailProduct}")
    public void deleteDetailCart(@PathVariable("IdCart") long idCart, @PathVariable("IdDetailProduct") long idDetailProduct) {
        Cart cart = cartService.getCartById(idCart);
        DetailProduct detailProduct = detailProductService.getDetailProductById(idDetailProduct);

        // xóa detail cart
        detailCartService.deleteDetailCart(detailCartService.getDetailCart(cart, detailProduct));
    }

}
