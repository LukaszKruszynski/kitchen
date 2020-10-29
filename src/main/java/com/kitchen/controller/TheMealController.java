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

    @GetMapping("/{name}")
    public TheMealDto getMealByName(@PathVariable String name) {
        return client.getMeal(name);
    }

    @GetMapping("/{ingredient}")
    public TheMealDto getMealByMainIngredient(@PathVariable String ingredient) {
        return client.getMealByMainIngredient(ingredient);
    }
}
