package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends ProductRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name, p.image, dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p.status = 0 " +
            "GROUP BY p.id, p.name, p.image, dp.sellPrice")
    List<UserProductResponse> getAllProductPageable(Pageable pageable);

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name, p.image, dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p.status = 0 " +
            "GROUP BY p.id, p.name, p.image, dp.sellPrice")
    List<UserProductResponse> getTotalPages();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name,p.image,  dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p.status = 0 " +
            "GROUP BY p.id, p.name, p.image, dp.sellPrice " +
            "ORDER BY p.id DESC " +
            "LIMIT 3 ")
    List<UserProductResponse> getTop3NewProduct();

}
