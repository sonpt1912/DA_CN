package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.entity.Brand;
import com.example.be.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/brand")
@CrossOrigin(origins = {"*"})
public class AdminBrandController {

    @Autowired
    private AdminBrandService service;

    @GetMapping("/get-all-brand")
    public List<Brand> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Brand getOneById(@PathVariable("id") long id) {
        return service.getOneById(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam String name) {
        Brand brand = Brand.builder()
                .name(name)
                .status(0)
                .build();
        service.add(brand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        Brand brand = service.getOneById(id);
        brand.setStatus(1);
        service.delete(brand);
    }

    @PutMapping("/update")
    public void update(@ModelAttribute Brand brand) {
        service.update(brand);
    }
}
