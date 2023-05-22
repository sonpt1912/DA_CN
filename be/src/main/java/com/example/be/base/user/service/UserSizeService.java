package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserSizeResponse;
import com.example.be.base.user.repository.UserSizeRepository;
import com.example.be.entity.Brand;
import com.example.be.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSizeService {

    @Autowired
    private UserSizeRepository response;

    public List<UserSizeResponse> getAllSize() {
        return response.getAllSize();
    }

    public List<UserSizeResponse> getSizeByProduct(long idProduct, long idColor) {
        return response.getSizeByIdProductAndIdColor(idProduct, idColor);
    }

    public Size getSizeById(long id) {
        return response.findSizeById(id);
    }


}
