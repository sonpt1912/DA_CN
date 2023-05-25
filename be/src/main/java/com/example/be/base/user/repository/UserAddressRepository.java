package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserAddressResponse;
import com.example.be.entity.Customer;
import com.example.be.repository.AddressRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends AddressRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserAddressResponse(ad.id, ad.description, ad.ward, ad.district, ad.city) " +
            "FROM Address ad " +
            "WHERE ad.customer = :Customer AND ad.status = 0")
    public List<UserAddressResponse> getAllByCustomer(@Param("Customer") Customer customer);

    @Query("SELECT NEW com.example.be.base.user.model.response.UserAddressResponse(ad.id, ad.description, ad.ward, ad.district, ad.city) " +
            "FROM Address ad " +
            "WHERE ad.id = :idAddress AND ad.status = 0")
    public UserAddressResponse getOneById(@Param("idAddress") long idAddress);

}
