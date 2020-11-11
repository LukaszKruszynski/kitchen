package com.kitchen.controller;

import com.kitchen.cocktail.client.CocktailClient;
import com.kitchen.dto.CocktailDto;
import com.kitchen.dto.CocktailListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/cocktails")
public class CocktailController {
    @Autowired
    private CocktailClient client;

    @GetMapping("/random")
    public CocktailListDto getRandomCocktail() {
        return client.getRandomCocktail();
    }

    @GetMapping("/search/name/{name}")
    public CocktailListDto getCocktailByName(@PathVariable String name) {
        return client.getCocktailByName(name);
    }

    @GetMapping("/search/ingredient/{ingredient}")
    public CocktailListDto getCocktailByMainIngredient(@PathVariable String ingredient) {
        return client.getCocktailByMainIngredient(ingredient);
    }

    @GetMapping("/{id}")
    public CocktailListDto getCocktailById(@PathVariable String id) {
        return client.getCocktailById(id);
    }

    @GetMapping("/list/ingredients")
    public CocktailListDto getIngredients() {
        return client.getIngredients();
    }
}
