package com.example.be.repository;

import com.example.be.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailProductRepository extends JpaRepository<DetailProduct, Long> {

    DetailProduct findDetailProductById(long id);

    DetailProduct findDetailProductByBrandAndColorAndCategoryAndSizeAAndProduct(Brand brand, Color color, Category category, Size size, Product product);

}
