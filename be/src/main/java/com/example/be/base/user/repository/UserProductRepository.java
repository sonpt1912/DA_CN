package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
import com.example.be.entity.Color;
import com.example.be.entity.Size;
import com.example.be.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends ProductRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name, p.image, dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p.status = 0 " +
            "AND (:Color  IS NULL OR dp.color = :Color) " +
            "AND (:Category IS NULL OR dp.category = :Category) " +
            "AND (:Brand IS NULL OR dp.brand = :Brand) " +
            "AND (:Size IS NULL OR dp.size = :Size) " +
            "GROUP BY p.id, p.name, p.image, dp.sellPrice")
    List<UserProductResponse> getAllProductPageable(Pageable pageable, @Param("Category") Category category, @Param("Brand") Brand brand, @Param("Size") Size size, @Param("Color") Color color);

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name, p.image, dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p.status = 0 " +
            "AND (:Color  IS NULL OR dp.color = :Color) " +
            "AND (:Category IS NULL OR dp.category = :Category) " +
            "AND (:Brand IS NULL OR dp.brand = :Brand) " +
            "AND (:Size IS NULL OR dp.size = :Size) " +
            "GROUP BY p.id, p.name, p.image, dp.sellPrice")
    List<UserProductResponse> getTotalPages(@Param("Category") Category category, @Param("Brand") Brand brand, @Param("Size") Size size, @Param("Color") Color color);

    @Query("SELECT NEW com.example.be.base.user.model.response.UserProductResponse(p.id, p.name,p.image,  dp.sellPrice) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "WHERE p.status = 0 " +
            "GROUP BY p.id, p.name, p.image, dp.sellPrice " +
            "ORDER BY p.id DESC " +
            "LIMIT 3 ")
    List<UserProductResponse> getTop3NewProduct();

}
