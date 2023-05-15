package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.entity.Product;
import com.example.be.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductResponseRepository extends ProductRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name,  ct.name, p.image, dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product INNER JOIN Category ct ON dp.category = ct " +
            "WHERE p.status = 0")
    List<UserProductResponse> getAllProduct();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name, ct.name, p.image,  dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product INNER JOIN Category ct ON dp.category = ct " +
            "WHERE p.status = 0" +
            "ORDER BY p.id DESC " +
            "LIMIT 3")
    List<UserProductResponse> getTop3NewProduct();

}
