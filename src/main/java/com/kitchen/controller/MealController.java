package com.kitchen.controller;

import com.kitchen.dto.MealCategoryListDto;
import com.kitchen.dto.MealListDto;
import com.kitchen.meal.client.MealClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/meals")
public class MealController {
    @Autowired
    private MealClient client;

    @GetMapping("/random")
    public MealListDto getRandomMeal() {
        return client.getRandomMeal();
    }

    @GetMapping("/search/name/{name}")
    public MealListDto getMealByName(@PathVariable String name) {
        return client.getMealByName(name);
    }

    @GetMapping("/search/ingredient/{ingredient}")
    public MealListDto getMealByMainIngredient(@PathVariable String ingredient) {
        return client.getMealsByMainIngredient(ingredient);
    }

    @GetMapping("/{id}")
    public MealListDto getMealById(@PathVariable String id) {
        return client.getMealById(id);
    }

    @GetMapping("/list/categories")
    public MealCategoryListDto getCategories() {
        return client.getCategories();
    }

    @GetMapping("/list/areas")
    public MealListDto getAreas() {
        return client.getAreas();
    }

    @GetMapping("/list/ingredients")
    public MealListDto getIngredients() {
        return client.getIngredients();
    }
}
