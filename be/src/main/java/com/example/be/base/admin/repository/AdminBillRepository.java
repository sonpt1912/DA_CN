package com.example.be.base.admin.repository;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.base.admin.model.response.AdminChartResponse;
import com.example.be.entity.Bill;
import com.example.be.repository.BillRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface AdminBillRepository extends BillRepository {

    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminBillResponse(b.id, b.code, SUM(db.quantity), SUM(db.quantity) , b.phoneNumber , b.createDate, b.paymentDate, b.address, b.description, b.status) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "LEFT JOIN  Voucher v ON v = b.voucher " +
            "GROUP BY b.id, b.code")
    List<AdminBillResponse> getAll();

    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminBillResponse(b.id, b.code, SUM(db.quantity), SUM(db.quantity) , b.phoneNumber , b.createDate, b.paymentDate,  b.address, b.description, b.status) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "LEFT JOIN  Voucher v ON v = b.voucher " +
            "WHERE b = :Bill " +
            "GROUP BY b.id, b.code")
    AdminBillResponse getOneByBill(@Param("Bill") Bill bill);


    // static
    @Query("SELECT SUM(db.quantity * db.price) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "WHERE b.status = 3 AND b.paymentDate BETWEEN :StartDate AND :EndDate")
    BigDecimal totalMoneyByThisMonth(@Param("StartDate") Date startDate, @Param("EndDate") Date endDate);

    @Query("SELECT SUM(db.quantity * db.price) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "WHERE b.status = 3 AND b.paymentDate BETWEEN :StartDate AND :EndDate")
    BigDecimal totalMoneyByYear(@Param("StartDate") Date startDate, @Param("EndDate") Date endDate);


    @Query("SELECT SUM(db.quantity) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "WHERE b.status = 3 AND b.paymentDate BETWEEN :StartDate AND :EndDate")
    Long totalProduct(@Param("StartDate") Date startDate, @Param("EndDate") Date endDate);


    @Query("SELECT NEW com.example.be.base.admin.model.response.AdminChartResponse(MONTH(b.paymentDate), SUM(db.quantity * db.price)) " +
            "FROM Bill b " +
            "INNER JOIN DetailBill db ON db.bill = b " +
            "WHERE b.status = 3 " +
            "GROUP BY MONTH(b.paymentDate)")
    List<AdminChartResponse> areaChart();

}
