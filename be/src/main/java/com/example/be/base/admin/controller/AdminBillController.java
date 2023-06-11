package com.example.be.base.admin.controller;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.base.admin.model.response.AdminChartResponse;
import com.example.be.base.admin.service.AdminBillService;
import com.example.be.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/admin/bill")
@CrossOrigin(origins = {"*"})
public class AdminBillController {

    @Autowired
    private AdminBillService service;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/get-all")
    public List<AdminBillResponse> getAll(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber) {
        return service.getAll(pageNumber);
    }

    @GetMapping("/get-total-pages-bill")
    public Integer getTotalPagesBill() {
        int page = (int) Math.ceil(service.getTotalPageBill().size() / 9) ;
        return page;
    }

    @GetMapping("/get-by-bill/{id}")
    public AdminBillResponse getOneById(@PathVariable("id") Long id) {
        Bill bill = service.findOneById(id);
        return service.getOneByBill(bill);
    }

    @PutMapping("/update-status-bill/{id}")
    public void updateStatus(@PathVariable("id") Long id, @RequestParam("status") int status) {
        Bill bill = service.findOneById(id);
        bill.setStatus(status + 1);
        service.updateStatus(bill);
    }

    @PutMapping("/cancel-status-bill/{id}")
    public void cancelStatus(@PathVariable("id") Long id) {
        Bill bill = service.findOneById(id);
        bill.setStatus(4);
        service.updateStatus(bill);
    }

    // static

    @GetMapping("/total-this-month")
    public BigDecimal totalThisMonth() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.withDayOfMonth(1); // Lấy ngày đầu tiên trong tháng
        LocalDate lastDayOfMonth = now.withDayOfMonth(now.lengthOfMonth()); // Lấy ngày cuối cùng trong tháng

        String formattedFirstDayOfMonth = dateFormat.format(Date.valueOf(firstDayOfMonth));
        String formattedLastDayOfMonth = dateFormat.format(Date.valueOf(lastDayOfMonth));

        return service.totalMoneyByThisMonth(Date.valueOf(formattedFirstDayOfMonth), Date.valueOf(formattedLastDayOfMonth));

    }

    @GetMapping("/total-this-year")
    public BigDecimal totalThisYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        LocalDate lastDayOfYear = LocalDate.of(year, 12, 31);


        String formattedFirstDayOfYear = dateFormat.format(Date.valueOf(firstDayOfYear));
        String formattedLastDayOfYear = dateFormat.format(Date.valueOf(lastDayOfYear));

        return service.totalMoneyByYear(Date.valueOf(formattedFirstDayOfYear), Date.valueOf(formattedLastDayOfYear));

    }

    @GetMapping("/total-product-this-year")
    public Long totalProduct() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        LocalDate lastDayOfYear = LocalDate.of(year, 12, 31);


        String formattedFirstDayOfYear = dateFormat.format(Date.valueOf(firstDayOfYear));
        String formattedLastDayOfYear = dateFormat.format(Date.valueOf(lastDayOfYear));

        return service.totalProduct(Date.valueOf(formattedFirstDayOfYear), Date.valueOf(formattedLastDayOfYear));

    }


    @GetMapping("/area-chart")
    public List<AdminChartResponse> areaChart() {
        return service.areaChart();
    }
}
