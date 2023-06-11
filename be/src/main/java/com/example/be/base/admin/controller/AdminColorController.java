package com.example.be.base.admin.controller;

import com.example.be.base.admin.service.AdminBrandService;
import com.example.be.base.admin.service.AdminColorService;
import com.example.be.entity.Brand;
import com.example.be.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/color")
@CrossOrigin(origins = {"*"})
public class AdminColorController {

    @Autowired
    private AdminColorService service;

    @GetMapping("/get-all-color")
    public List<Color> getAll() {
        return service.getAll();
    }

    @GetMapping("/get-color-by-status")
    public List<Color> getAllByStauts() {
        return service.getAllColorByStatus(0);
    }

    @GetMapping("/get/{id}")
    public Color getOneById(@PathVariable("id") long id) {
        return service.getOneById(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam("nameColor") String name) {
        Color color = Color.builder()
                .name(name)
                .status(0)
                .build();
        service.add(color);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        Color color = service.getOneById(id);
        color.setStatus(1);
        service.delete(color);
    }

    @PutMapping("/update")
    public void update(@RequestBody Color color){
        service.update(color);
    }

}
