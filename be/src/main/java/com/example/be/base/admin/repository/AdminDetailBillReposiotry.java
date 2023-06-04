package com.example.be.base.admin.repository;

import com.example.be.base.admin.model.response.AdminDetailBillResponse;
import com.example.be.entity.Bill;
import com.example.be.repository.DetailBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDetailBillReposiotry extends DetailBillRepository {

    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminDetailBillResponse(p.image, p.name, c.name, s.name, SUM(db.quantity), SUM(db.price)) " +
            "FROM Product p INNER JOIN DetailProduct dp ON p = dp.product " +
            "INNER JOIN Color c ON c = dp.color INNER JOIN Size s ON s = dp.size " +
            "INNER JOIN DetailBill db ON db.detailProduct = dp " +
            "INNER JOIN Bill b ON b = db.bill " +
            "WHERE b = :Bill " +
            "GROUP BY p.image, p.name, c.name, s.name")
    public List<AdminDetailBillResponse> getAllDetailBillByBill(@Param("Bill") Bill bill);

}
