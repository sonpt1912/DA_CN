package com.example.be.repository;

import com.example.be.entity.Address;
import com.example.be.entity.DetailBill;
import com.example.be.entity.DetailBillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailBillRepository extends JpaRepository<DetailBill, DetailBillId> {
}
