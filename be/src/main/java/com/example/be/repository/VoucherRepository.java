package com.example.be.repository;

import com.example.be.entity.Bill;
import com.example.be.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    Voucher findVoucherByCode(String code);

    @Query("FROM Voucher  v " +
            "INNER JOIN Bill b ON b.voucher = v " +
            "WHERE b = :Bill")
    Voucher findVoucherByBill(@Param("Bill")Bill bill);

}
