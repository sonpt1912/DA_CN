package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.base.admin.service.AdminSizeService;
import com.example.be.entity.Brand;
import com.example.be.entity.Color;
import com.example.be.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin(origins = {"*"})
public class AdminSizeController {

    @Autowired
    private AdminSizeService service;

    @GetMapping("/get-all-size")
    public List<Size> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Size getOneById(@PathVariable("id") long id) {
        return service.getOneById(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam String name) {
        Size size = Size.builder()
                .name(name)
                .status(0)
                .build();
        service.add(size);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        Size size = service.getOneById(id);
        size.setStatus(1);
        service.delete(size);
    }

    @PutMapping("/update")
    public void update(@ModelAttribute Size size) {
        service.update(size);
    }

}
