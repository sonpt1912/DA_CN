package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserCategoryResponse;
import com.example.be.repository.CategoryRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCategoryRepository extends CategoryRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserCategoryResponse(c.id, c.name) " +
            "FROM Category c WHERE c.status = 0")
    List<UserCategoryResponse> getAllCategory();

    @Query("SELECT NEW com.example.be.base.user.model.response.UserCategoryResponse(c.id, c.name) " +
            "FROM Category c INNER JOIN DetailProduct  dp ON c = dp.category INNER JOIN Product p ON dp.product = p " +
            "WHERE p.id = :IdProduct " +
            "GROUP BY c.id, c.name")
    UserCategoryResponse getCategoryByIdProduct(@Param("IdProduct") long idProduct);

}
