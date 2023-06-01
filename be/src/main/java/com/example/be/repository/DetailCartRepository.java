package com.example.be.repository;

import com.example.be.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailCartRepository extends JpaRepository<DetailCart, DetailCartId> {

    DetailCart findDetailCartByCartAndAndDetailProduct(Cart cart, DetailProduct detailProduct);

    List<DetailCart> findDetailCartsByCart(Cart cart);
}
