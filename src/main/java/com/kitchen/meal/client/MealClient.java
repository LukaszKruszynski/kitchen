package com.kitchen.meal.client;

import com.kitchen.dto.MealCategoryListDto;
import com.kitchen.dto.MealDto;
import com.kitchen.dto.MealListDto;
import com.kitchen.meal.configuration.MealConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MealClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MealConfig config;

    private URI buildUrlRandomMeal() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/random.php")
                .build().encode().toUri();
    }

    private URI buildUrlSearchMealByName(String name) {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/search.php?s=" + name)
                .build().encode().toUri();
    }

    private URI buildUrlSearchByMainIngredient(String ingredient) {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/filter.php?i=" + ingredient)
                .build().encode().toUri();
    }

    private URI buildUrlSearchById(String id) {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/lookup.php?i=" + id)
                .build().encode().toUri();
    }

    private URI buildUrlGetCategories() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/categories.php")
                .build().encode().toUri();
    }

    private URI buildUrlGetAreas() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/list.php?a=list")
                .build().encode().toUri();
    }

    private URI buildUrlGetIngredients() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/list.php?i=list")
                .build().encode().toUri();
    }

    public MealListDto getRandomMeal() {
        return restTemplate.getForObject(buildUrlRandomMeal(), MealListDto.class);
    }

    public MealListDto getMealByName(String name) {
        return restTemplate.getForObject(buildUrlSearchMealByName(name), MealListDto.class);
    }

    public MealListDto getMealsByMainIngredient(String ingredient) {
        return restTemplate.getForObject(buildUrlSearchByMainIngredient(ingredient), MealListDto.class);
    }

    public MealListDto getMealById(String id) {
        return restTemplate.getForObject(buildUrlSearchById(id), MealListDto.class);
    }

    public MealCategoryListDto getCategories() {
        return restTemplate.getForObject(buildUrlGetCategories(), MealCategoryListDto.class);
    }
}
