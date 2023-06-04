package com.example.be.base.admin.repository;

import com.example.be.base.admin.model.response.AdminCustomerResponse;
import com.example.be.entity.Bill;
import com.example.be.repository.CustomerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCustomerRepository extends CustomerRepository {

    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminCustomerResponse(c.firstName,c.lastName) " +
            "FROM Customer c INNER JOIN Bill  b ON b.customer = c " +
            "WHERE b = :Bill")
    AdminCustomerResponse getOneByBill(@Param("Bill") Bill bill);

}
