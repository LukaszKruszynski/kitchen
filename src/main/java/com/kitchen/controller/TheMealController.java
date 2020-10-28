package com.kitchen.controller;

import com.kitchen.domain.TheMeal;
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
    public TheMeal getRandomMeal() {
        return client.getRandomMeal();
    }

    @GetMapping("/search={name}")
    public TheMeal getMealByName(@PathVariable String name) {
        return client.getMeal(name);
    }
}
