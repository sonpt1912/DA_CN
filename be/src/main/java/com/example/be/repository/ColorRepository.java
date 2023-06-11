package com.example.be.repository;

import com.example.be.entity.Brand;
import com.example.be.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Color findColorById(long id);

    List<Color> findColorsByStatus(int status);

}
