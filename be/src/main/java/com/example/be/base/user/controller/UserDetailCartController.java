package com.example.be.base.user.controller;

import com.example.be.base.user.model.request.UserDetailProductRequest;
import com.example.be.base.user.model.response.UserDetailCartResponse;
import com.example.be.base.user.model.response.UserDetailProductResponse;
import com.example.be.base.user.service.*;
import com.example.be.entity.*;
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

    @Autowired
    private UserColorService colorService;

    @Autowired
    private UserBrandService brandService;

    @Autowired
    private UserCategoryService categoryService;

    @Autowired
    private UserSizeService sizeService;

    @Autowired
    private UserProductService productService;


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

    @PostMapping("/add-detail-cart")
    public void addToCart(@RequestBody UserDetailProductRequest userDetailProductRequest) {
        // tìm detailproduct
        Brand brand = brandService.getBrandById(userDetailProductRequest.getIdBrand());
        Color color = colorService.getColorById(userDetailProductRequest.getIdColor());
        Category category = categoryService.getCategoryById(userDetailProductRequest.getIdCategory());
        Size size = sizeService.getSizeById(userDetailProductRequest.getIdSize());
        Product product = productService.getProductById(userDetailProductRequest.getIdProduct());
        DetailProduct detailProduct = detailProductService.getDetailProductByCategoryAndSizeAndBrandAndColorAndProduct(brand, color, category, size, product);
        // find cart
        Cart cart = cartService.getCartById(userDetailProductRequest.getIdCart());
        // save to detail cart
        DetailCart detailCart = DetailCart.builder()
                .cart(cart)
                .detailProduct(detailProduct)
                .quantity(userDetailProductRequest.getQuantity())
                .build();
        detailCartService.saveDetailCart(detailCart);

    }

}
