package com.example.be.base.admin.repository;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.repository.BillRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminBillRepository extends BillRepository {

    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminBillResponse(b.id, b.code, SUM(db.quantity),( SUM(db.quantity) - COALESCE(v.discountAmount, 0)) , b.phoneNumber , b.createDate, b.status) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "LEFT JOIN  Voucher v ON v = b.voucher " +
            "GROUP BY b.id, b.code")
    List<AdminBillResponse> getAll();


}
