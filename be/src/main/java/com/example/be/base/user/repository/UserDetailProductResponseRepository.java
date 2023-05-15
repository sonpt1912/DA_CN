package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserBrandResponse;
import com.example.be.base.user.model.response.UserDetailProductResponse;
import com.example.be.repository.BrandRepository;
import com.example.be.repository.DetailProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailProductResponseRepository extends DetailProductRepository {

//    @Query("SELECT NEW com.example.be.base.user.model.response.UserBrandResponse(b.id, b.name) " +
//            "FROM Brand b WHERE b.status = 0")
//    List<UserDetailProductResponse> getAllBrand();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserDetailProductResponse(dp.id, p.name, p.image, dp.description, dp.sellPrice) " +
            "FROM Brand b INNER JOIN DetailProduct  dp ON b = dp.brand INNER JOIN Product p ON dp.product = p " +
            "WHERE p.id = :IdProduct")
    UserDetailProductResponse getDetailProductByProduct(@Param("IdProduct") long idProduct);

}
