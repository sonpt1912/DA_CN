package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.repository.ColorRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserColorResponseRepository extends ColorRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserColorResponse(c.id, c.name) " +
            "FROM Color c WHERE c.status = 0")
    List<UserColorResponse> getAllColor();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserColorResponse(c.id, c.name) " +
            "FROM Color c INNER JOIN DetailProduct  dp ON c = dp.color INNER JOIN Product p ON dp.product = p " +
            "WHERE p.id = :IdProduct")
    List<UserColorResponse> getColorByIdProduct(@Param("IdProduct") long idProduct);


}
