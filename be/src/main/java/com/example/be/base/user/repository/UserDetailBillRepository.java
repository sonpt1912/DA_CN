package com.example.be.base.user.repository;

import com.example.be.base.user.model.response.UserDetailBillResponse;
import com.example.be.entity.Bill;
import com.example.be.repository.DetailBillRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailBillRepository extends DetailBillRepository {

    @Query("SELECT NEW com.example.be.base.user.model.response.UserDetailBillResponse(p.image, p.name, c.name, s.name, SUM(db.quantity), SUM(db.price)) " +
            "FROM Product p INNER JOIN  DetailProduct dp ON p = dp.product " +
            "INNER JOIN Color c ON c = dp.color INNER JOIN Size s ON s = dp.size " +
            "INNER JOIN DetailBill db ON db.detailProduct = dp " +
            "WHERE dp IN (SELECT detailProduct FROM DetailBill WHERE bill =:Bill) " +
            "GROUP BY p.image, p.name, c.name, s.name")
    public List<UserDetailBillResponse> getAllDetailBillByBill(@Param("Bill") Bill bill);

}
