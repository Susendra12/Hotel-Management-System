package com.example.SpringSecurity_Register_Login.service;

import com.example.SpringSecurity_Register_Login.entity.Food;
import com.example.SpringSecurity_Register_Login.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getListOfFood() {
        return foodRepository.findAll();
    }

    public List<Food> getFoodsByCategory(String category) {
        return foodRepository.getFoodByCategory(category);
    }


    public Food updateFood(Long id, Food food) {

        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food with name " + id + " not found"));

        // Update fields
        existingFood.setDescription(food.getDescription());
        existingFood.setPrice(food.getPrice());
        existingFood.setAvailable(food.isAvailable());
        existingFood.setName(food.getName());
        existingFood.setCategory(food.getCategory());
        // You can update other fields as needed

        // Save and return the updated entity
        return foodRepository.save(existingFood);
    }

    public void deleteFood(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with name: " + id));

        foodRepository.delete(food);
    }
}
