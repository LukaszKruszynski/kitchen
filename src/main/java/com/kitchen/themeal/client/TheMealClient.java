package com.kitchen.themeal.client;

import com.kitchen.dto.TheMealDto;
import com.kitchen.themeal.configuration.TheMealConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class TheMealClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TheMealConfig config;

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
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/list.php?c=list")
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

    public TheMealDto getRandomMeal() {
        return restTemplate.getForObject(buildUrlRandomMeal(), TheMealDto.class);
    }

    public TheMealDto getMealByName(String name) {
        return restTemplate.getForObject(buildUrlSearchMealByName(name), TheMealDto.class);
    }

    public TheMealDto getMealByMainIngredient(String ingredient) {
        return restTemplate.getForObject(buildUrlSearchByMainIngredient(ingredient), TheMealDto.class);
    }

    public TheMealDto getMealById(String id) {
        return restTemplate.getForObject(buildUrlSearchById(id), TheMealDto.class);
    }

    public TheMealDto getCategories() {
        return restTemplate.getForObject(buildUrlGetCategories(), TheMealDto.class);
    }

    public TheMealDto getAreas() {
        return restTemplate.getForObject(buildUrlGetAreas(), TheMealDto.class);
    }

    public TheMealDto getIngredients() {
        return restTemplate.getForObject(buildUrlGetIngredients(), TheMealDto.class);

    }
}
