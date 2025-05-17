package com.example.SpringSecurity_Register_Login.repository;

import com.example.SpringSecurity_Register_Login.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> getFoodByCategory(String category);
    Optional<Food> findByName(String name);
    void deleteByName(String name);

}
