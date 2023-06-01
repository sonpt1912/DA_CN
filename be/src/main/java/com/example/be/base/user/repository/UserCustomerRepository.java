package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserCustomerResponse;
import com.example.be.repository.CustomerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomerRepository extends CustomerRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserCustomerResponse(c.username, c.lastName, c.firstName, c.phoneNumber, c.email) " +
            "FROM Customer c " +
            "WHERE c.id = :IdCustomer")
    UserCustomerResponse getOneResponseById(@Param("IdCustomer") long idCustomer);


}
