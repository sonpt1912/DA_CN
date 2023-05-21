package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserFavoriteResponse;
import com.example.be.base.user.service.UserCustomerService;
import com.example.be.base.user.service.UserFavoriteService;
import com.example.be.base.user.service.UserProductService;
import com.example.be.entity.Customer;
import com.example.be.entity.Favorite;
import com.example.be.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/favorite")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class UseFavoriteController {


    private final UserFavoriteService favoriteService;

    private final UserProductService productService;

    private final UserCustomerService customerService;

    @GetMapping("/get-all-by-customer/{idCustomer}")
    public List<UserFavoriteResponse> getAllFavoriteByCustomer(@PathVariable("idCustomer") long id) {
        Customer customer = customerService.findCustomerById(id);
        return favoriteService.getAllFavoriteByCustomer(customer);
    }

    @GetMapping("/get-one-by-customer-product/{idCustomer}/{idProduct}")
    public UserFavoriteResponse getOneFavoriteByCustomer(@PathVariable("idProduct") long idProduct, @PathVariable("idCustomer") long idCustomer) {
        Product product = productService.findProductById(idProduct);
        Customer customer = customerService.findCustomerById(idCustomer);
        // find favorite
        UserFavoriteResponse favoriteResponse = favoriteService.getOneFavoriteByCustomerAndProduct(customer, product);

        return favoriteResponse;
    }

    @PostMapping("/save-favorite/{idCustomer}/{idProduct}")
    public void saveFavorite(@PathVariable("idProduct") long idProduct, @PathVariable("idCustomer") long idCustomer) {
        // get object
        Product product = productService.findProductById(idProduct);
        Customer customer = customerService.findCustomerById(idCustomer);
        Favorite favorite = new Favorite(customer, product);
        // save favorite
        favoriteService.saveFavorite(favorite);
    }

    @DeleteMapping("/delete-favorite/{idCustomer}/{idProduct}")
    public void deleteFavorite(@PathVariable("idProduct") long idProduct, @PathVariable("idCustomer") long idCustomer) {
        // get object
        Product product = productService.findProductById(idProduct);
        Customer customer = customerService.findCustomerById(idCustomer);
        Favorite favorite = new Favorite(customer, product);
        // save favorite
        favoriteService.deleteFavorite(favorite);
    }

}
