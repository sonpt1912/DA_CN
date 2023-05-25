package com.example.be.base.user.controller;

import com.example.be.base.user.model.request.UserDetailCartRequest;
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
    public List<UserDetailCartResponse> getAllById(@PathVariable("IdCart") long id) {
        return detailCartService.getAllUserDetailCartByCart(id);
    }

    @DeleteMapping("/delete-detail-cart/{IdCart}/{IdDetailProduct}")
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
        DetailProduct detailProduct = detailProductService.findDetailProductByBrandAndColorAndCategoryAndSizeAndProduct(brand, color, category, size, product);
        // find cart
        Cart cart = cartService.getCartByStatus(0L);
        // save to detail cart

        DetailCart detailCart = detailCartService.getDetailCart(cart, detailProduct);
        if (detailCart == null) {
            DetailCart saveDetailCart = DetailCart.builder()
                    .cart(cart)
                    .detailProduct(detailProduct)
                    .quantity(userDetailProductRequest.getQuantity())
                    .build();
            detailCartService.saveDetailCart(saveDetailCart);
        } else {
            int quantity = detailCart.getQuantity() + userDetailProductRequest.getQuantity();
            detailCart.setQuantity(quantity);
            detailCartService.saveDetailCart(detailCart);
        }
    }

    @PutMapping("/update-detail-cart")
    public void updateQuantity(@RequestBody UserDetailCartRequest userDetailCartRequest) {
        DetailProduct detailProduct = detailProductService.getDetailProductById(userDetailCartRequest.getIdDetailProduct());
        Cart cart = cartService.getCartById(userDetailCartRequest.getIdCart());

        DetailCart detailCart = detailCartService.getDetailCart(cart, detailProduct);
        detailCart.setQuantity(userDetailCartRequest.getQuantity());
        detailCartService.saveDetailCart(detailCart);
    }

}
