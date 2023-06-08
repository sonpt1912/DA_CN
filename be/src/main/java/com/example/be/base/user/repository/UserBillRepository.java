package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserBillResponse;
import com.example.be.entity.Bill;
import com.example.be.entity.Customer;
import com.example.be.repository.BillRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBillRepository extends BillRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserBillResponse(b.id, b.code, SUM(db.quantity), b.phoneNumber, b.createDate, b.paymentDate, b.address,  b.status) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "LEFT JOIN  Voucher v ON v = b.voucher " +
            "WHERE b.customer = :Customer AND b.status = :IdStatus  " +
            "GROUP BY b.id, b.code ")
    List<UserBillResponse> getAllByCustomerAndStatus(@Param("Customer") Customer customer, @Param("IdStatus") int idStatus);

    @Query("SELECT NEW com.example.be.base.user.model.response.UserBillResponse(b.id, b.code, SUM(db.quantity),  b.phoneNumber, b.createDate, b.paymentDate, b.address, b.status) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "LEFT JOIN  Voucher v ON v = b.voucher " +
            "WHERE b =:Bill " +
            "GROUP BY b.id, b.code ")
    UserBillResponse getOneByResponseByBill(@Param("Bill") Bill bill);

}
