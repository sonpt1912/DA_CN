package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.entity.Bill;
import com.example.be.repository.VoucherRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVoucherRepository extends VoucherRepository {

    @Query("SELECT NEW  com.example.be.base.user.model.response.UserVoucherResponse(v.id, v.discountAmount) " +
            "FROM Voucher v " +
            "WHERE v.code = :CodeVoucher AND v.status = 0")
    UserVoucherResponse getByCode(@Param("CodeVoucher") String code);

    @Query("SELECT NEW  com.example.be.base.user.model.response.UserVoucherResponse(v.id, v.discountAmount) " +
            "FROM Voucher v INNER JOIN Bill b ON b.voucher = v " +
            "WHERE b =:Bill")
    UserVoucherResponse getByBill(@Param("Bill")Bill bill);
}
