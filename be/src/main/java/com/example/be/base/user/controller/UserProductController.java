package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserColorResponse;
import com.example.be.base.user.model.response.UserProductResponse;
import com.example.be.base.user.service.*;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
import com.example.be.entity.Color;
import com.example.be.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/product")
@CrossOrigin(origins = {"*"})
public class UserProductController {

    @Autowired
    private UserProductService productService;

    @Autowired
    private UserCategoryService categoryService;

    @Autowired
    private UserBrandService brandService;

    @Autowired
    private UserSizeService sizeService;

    @Autowired
    private UserColorService colorService;

    @GetMapping("/get-all")
    public List<UserProductResponse> getAll(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam("Category") Long idCategory, @RequestParam("Brand") Long idBrand, @RequestParam("Size") Long idSize, @RequestParam("Color") Long idColor) {
        Brand brand = brandService.getBrandById(Long.valueOf(idBrand));
        Category category = categoryService.getCategoryById(Long.valueOf(idCategory));
        Size size = sizeService.getSizeById(Long.valueOf(idSize));
        Color color = colorService.getColorById(Long.valueOf(idColor));
        List<UserProductResponse> listProductResponse = productService.getAllProductPageable(pageNumber, category, brand, size, color);
        return listProductResponse;
    }

    @GetMapping("/get-total-pages")
    public Integer getTotalPages(@RequestParam("Category") Long idCategory, @RequestParam("Brand") Long idBrand, @RequestParam("Size") Long idSize, @RequestParam("Color") Long idColor) {
        Brand brand = brandService.getBrandById(Long.valueOf(idBrand));
        Category category = categoryService.getCategoryById(Long.valueOf(idCategory));
        Size size = sizeService.getSizeById(Long.valueOf(idSize));
        Color color = colorService.getColorById(Long.valueOf(idColor));
        int page = (int) Math.ceil(productService.getTotalPages(category, brand, size, color).size() / 9) - 1;
        return page;
    }

    @GetMapping("/get-3-new-product")
    public List<UserProductResponse> getTop3NewProduct() {
        return productService.getTop3NewProduct();
    }

}
