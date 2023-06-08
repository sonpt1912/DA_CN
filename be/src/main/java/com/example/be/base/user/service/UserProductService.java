package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.base.user.repository.UserProductRepository;
import com.example.be.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductService {

    @Autowired
    private UserProductRepository response;

    public List<UserProductResponse> getAllProductPageable(int pageNumber) {
        int pageSize = 1; // kích thước trang

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return response.getAllProductPageable(pageable);
    }

    public List<UserProductResponse> getTotalPages() {
        return response.getTotalPages();
    }

    public List<UserProductResponse> getTop3NewProduct() {
        return response.getTop3NewProduct();
    }

    public Product getProductById(long id) {
        return response.findProductById(id);
    }


}
