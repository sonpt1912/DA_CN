package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.base.user.repository.UserVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVoucherService {

    @Autowired
    private UserVoucherRepository repository;

    public UserVoucherResponse getVoucherByCode(String code) {
        return repository.getByCode(code);
    }
}
