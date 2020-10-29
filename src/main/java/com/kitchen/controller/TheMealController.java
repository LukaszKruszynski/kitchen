package com.kitchen.controller;

import com.kitchen.dto.TheMealDto;
import com.kitchen.themeal.client.TheMealClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/meals")
public class TheMealController {
    @Autowired
    private TheMealClient client;

    @GetMapping("/random")
    public TheMealDto getRandomMeal() {
        return client.getRandomMeal();
    }

    @GetMapping("/search/name/{name}")
    public TheMealDto getMealByName(@PathVariable String name) {
        return client.getMealByName(name);
    }

    @GetMapping("/search/ingredient/{ingredient}")
    public TheMealDto getMealByMainIngredient(@PathVariable String ingredient) {
        return client.getMealByMainIngredient(ingredient);
    }

    @GetMapping("/{id}")
    public TheMealDto getMealById(@PathVariable String id) {
        return client.getMealById(id);
    }

    @GetMapping("/list/categories")
    public TheMealDto getCategories() {
        return client.getCategories();
    }

    @GetMapping("/list/areas")
    public TheMealDto getAreas() {
        return client.getAreas();
    }

    @GetMapping("/list/ingredients")
    public TheMealDto getIngredients() {
        return client.getIngredients();
    }
}
