package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserFavoriteResponse;
import com.example.be.entity.Customer;
import com.example.be.entity.Product;
import com.example.be.repository.FavoriteRepositor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteRepository extends FavoriteRepositor {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserFavoriteResponse( c.id, p.id, p.name, p.image, dp.sellPrice) " +
            "FROM Favorite f INNER JOIN Product p ON f.product = p INNER JOIN DetailProduct dp ON dp.product = p " +
            "INNER JOIN Customer c ON c = f.customer " +
            "WHERE c = :Customer " +
            "GROUP BY c.id, p.id, p.name, p.image, dp.sellPrice")
    List<UserFavoriteResponse> getAllByCustomer(@Param("Customer") Customer customer);

    @Query("SELECT NEW com.example.be.base.user.model.response.UserFavoriteResponse(c.id, p.id,  p.name, p.image, dp.sellPrice) " +
            "FROM Favorite f INNER JOIN Product p ON f.product = p INNER JOIN DetailProduct dp ON dp.product = p " +
            "INNER JOIN Customer c ON c = f.customer " +
            "WHERE c = :Customer AND p = :Product")
    UserFavoriteResponse getOneByCustomerAndProduct(@Param("Customer") Customer customer, @Param("Product") Product product);

}
