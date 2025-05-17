package com.example.SpringSecurity_Register_Login.restController;

import com.example.SpringSecurity_Register_Login.entity.Food;
import com.example.SpringSecurity_Register_Login.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/add")
    public Food addFood(@RequestBody Food food){
        return foodService.addFood(food);
    }

    @GetMapping("/ListOfFood")
    public List<Food> getListOfFood(){
        return foodService.getListOfFood();
    }

    @GetMapping("/getFood/{category}")
    public List<Food> getFoodByCategory(@PathVariable String category) {
        return foodService.getFoodsByCategory(category);
	}

    @PutMapping("/update/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food food) {
        return foodService.updateFood(id, food);

    }
    @DeleteMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
        return "Delete Successfully";
    }

}
