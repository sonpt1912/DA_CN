package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.repository.BrandRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBrandRepository extends BrandRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserBrandResponse(b.id, b.name) " +
            "FROM Brand b WHERE b.status = 0")
    List<UserBrandResponse> getAllBrand();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserBrandResponse(b.id, b.name) " +
            "FROM Brand b INNER JOIN DetailProduct  dp ON b = dp.brand INNER JOIN Product p ON dp.product = p " +
            "WHERE p.id = :IdProduct " +
            "GROUP BY b.id, b.name")
    UserBrandResponse getBrandByIdProduct(@Param("IdProduct") long idProduct);



}
