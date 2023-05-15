package com.example.be.repository;

import com.example.be.entity.Favorite;
import com.example.be.entity.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepositor extends JpaRepository<Favorite, FavoriteId> {
}
