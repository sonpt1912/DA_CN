package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserDetailProductResponse;
import com.example.be.repository.DetailProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailProductRepository extends DetailProductRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserDetailProductResponse( p.name, p.image, dp.description, dp.sellPrice) " +
            "FROM Brand b INNER JOIN DetailProduct  dp ON b = dp.brand INNER JOIN Product p ON dp.product = p " +
            "WHERE p.id = :IdProduct " +
            "GROUP BY p.name, p.image, dp.description, dp.sellPrice")
    UserDetailProductResponse getDetailProductByProduct(@Param("IdProduct") long idProduct);

}
