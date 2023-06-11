package com.example.be.base.user.controller;

import com.example.be.base.user.model.request.UserBillRequest;
import com.example.be.base.user.model.response.UserBillResponse;
import com.example.be.base.user.service.UserBillService;
import com.example.be.base.user.service.UserCartService;
import com.example.be.base.user.service.UserCustomerService;
import com.example.be.base.user.service.UserDetailBillService;
import com.example.be.base.user.service.UserDetailCartService;
import com.example.be.base.user.service.UserVoucherService;
import com.example.be.entity.Bill;
import com.example.be.entity.Cart;
import com.example.be.entity.Customer;
import com.example.be.entity.DetailBill;
import com.example.be.entity.DetailCart;
import com.example.be.entity.DetailProduct;
import com.example.be.entity.Voucher;
import com.example.be.base.user.util.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/user/bill")
public class UserBillController {

    @Autowired
    private UserBillService billService;

    @Autowired
    private UserCustomerService customerService;

    @Autowired
    private UserCartService cartService;

    @Autowired
    private UserDetailCartService detailCartService;

    @Autowired
    private UserVoucherService voucherService;

    @Autowired
    private UserDetailBillService detailBillService;

    @Autowired
    private RandomCode randomCode;

    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    private Date currentDate = new Date();

    @GetMapping("/get-all-by-customer-status/{idCustomer}/{status}")
    public List<UserBillResponse> getAllByCustomerAndStatus(@PathVariable("idCustomer") long idCusomter, @PathVariable("status") int status) {
        Customer customer = customerService.findCustomerById(idCusomter);
        return billService.getAllByCustomerAndStatus(customer, status);
    }

    @GetMapping("/get-by-id/{id}")
    public UserBillResponse getResponseById(@PathVariable("id") long id) {
        Bill bill = billService.getOneById(id);
        return billService.getOneResponseByBill(bill);
    }

    @PostMapping("/add-to-bill")
    public void getAllByCustomerAndStatus(@RequestBody UserBillRequest userBillRequest) {
        // tìm cart
        Cart cart = cartService.getCartById(userBillRequest.getIdCart());
        // tìm customer
        Customer customer = customerService.findCustomerById(userBillRequest.getIdCustomer());
        // tìm voucher
        Voucher voucher = voucherService.getByCode(userBillRequest.getCodeVoucher());
        // tạo bill
        Bill bill = billService.addOrUpdate(Bill.builder()
                .code(randomCode.generateRandomNumber())
                .address(userBillRequest.getAddress())
                .status(0)
                .address(userBillRequest.getAddress())
                .description(userBillRequest.getDescription())
                .phoneNumber(customer.getPhoneNumber())
                .customer(customer)
                .voucher(voucher)
                .createDate(java.sql.Date.valueOf(formatDate.format(currentDate)))
                .build());
        // lấy list detailProduct

        List<DetailCart> detailCartList = detailCartService.getAllByCart(cart);
        // list detailproduct
        List<DetailProduct> listDetailProduct = new ArrayList<>();
        detailCartList.forEach(detailCart -> {
            listDetailProduct.add(detailCart.getDetailProduct());
        });
        // add detail bill
        List<DetailBill> listB = new ArrayList<>();
        for (int i = 0; i < detailCartList.size(); i++) {
            listB.add(new DetailBill(bill, listDetailProduct.get(i), detailCartList.get(i).getQuantity(), listDetailProduct.get(i).getSellPrice()));
        }
        detailBillService.addListDetailBill(listB);


        /// xóa hết dữ liệu trong detail cart từ cart
        for (DetailCart dc : detailCartList) {
            detailCartService.deleteDetailCart(dc);
        }
    }

    @PutMapping("/cancel-status-bill/{id}")
    public void cancelStatus(@PathVariable("id") Long id) {
        Bill bill = billService.getOneById(id);
        bill.setStatus(4);
        billService.updateStatus(bill);
    }

}
