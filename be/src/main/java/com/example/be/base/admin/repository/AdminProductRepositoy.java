package com.example.be.base.admin.repository;

import com.example.be.base.admin.model.response.AdminProductResponse;
import com.example.be.entity.Product;
import com.example.be.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductRepositoy extends ProductRepository {

    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminProductResponse(p.image, p.name, dp.sellPrice, p.description) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p = :Product " +
            "GROUP By p.image, p.name, dp.sellPrice")
    AdminProductResponse getOneById(@Param("Product") Product product);

}
