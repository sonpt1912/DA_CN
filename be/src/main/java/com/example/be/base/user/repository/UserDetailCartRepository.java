package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserDetailCartResponse;
import com.example.be.entity.DetailCart;
import com.example.be.repository.DetailCartRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailCartRepository extends DetailCartRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserDetailCartResponse(dp.id, dp.product.name,dp.size.name, dp.color.name, dp.product.image, dc.quantity, dp.sellPrice) " +
            "FROM DetailCart dc INNER JOIN Cart c ON dc.cart = c INNER JOIN DetailProduct dp ON dc.detailProduct = dp " +
            "WHERE c.id = :IdCart ")
    List<UserDetailCartResponse> getAllByCart(@Param("IdCart") long id);


}
