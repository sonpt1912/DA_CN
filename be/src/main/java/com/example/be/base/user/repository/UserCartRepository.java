package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserCartResponse;
import com.example.be.repository.CartRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartRepository extends CartRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserCartResponse(c.id) " +
            "FROM Cart c INNER JOIN Customer cus ON c.customer = cus " +
            "WHERE cus.id = :IdCustomer AND c.status = 0")
    UserCartResponse getByCustomer(@Param("IdCustomer") long idCustomer);

}
