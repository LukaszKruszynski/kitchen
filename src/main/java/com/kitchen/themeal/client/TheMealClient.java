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

    public TheMealDto getRandomMeal() {
        return restTemplate.getForObject(buildUrlRandomMeal(), TheMealDto.class);
    }

    public TheMealDto getMeal(String name) {
        return restTemplate.getForObject(buildUrlSearchMealByName(name), TheMealDto.class);
    }

    public TheMealDto getMealByMainIngredient(String ingredient) {
        return restTemplate.getForObject(buildUrlSearchByMainIngredient(ingredient), TheMealDto.class);
    }

}
