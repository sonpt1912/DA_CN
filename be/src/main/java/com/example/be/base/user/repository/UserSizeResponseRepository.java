package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.model.response.UserSizeResponse;
import com.example.be.repository.SizeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSizeResponseRepository extends SizeRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserSizeResponse(s.id, s.name) " +
            "FROM Size s WHERE s.status = 0")
    List<UserSizeResponse> getAllSize();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserSizeResponse(s.id, s.name) " +
            "FROM Size s INNER JOIN DetailProduct dp ON s = dp.size INNER JOIN Product p ON dp.product = p " +
            "WHERE p.id = :IdProduct")
    List<UserSizeResponse> getSizeByIdProduct(@Param("IdProduct") long idProduct);


}
