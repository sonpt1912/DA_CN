package com.example.be.repository;

import com.example.be.entity.Address;
import com.example.be.entity.DetailCart;
import com.example.be.entity.DetailCartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailCartRepository extends JpaRepository<DetailCart, DetailCartId> {
}
