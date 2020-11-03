package com.kitchen.cocktail.client;

import com.kitchen.dto.CocktailDto;
import com.kitchen.cocktail.configuration.CocktailConfig;
import com.kitchen.dto.CocktailListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CocktailClient {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CocktailConfig config;

    private URI buildUrlRandomCocktail() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/random.php")
                .build().encode().toUri();
    }

    private URI buildUrlSearchCocktailByName(String name) {
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

    private URI buildUrlGetIngredients() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/list.php?i=list")
                .build().encode().toUri();
    }

    private URI buildURLGetAlcoholicFilters() {
        return UriComponentsBuilder.fromHttpUrl(config.getBasicUrl() + "/list.php?a=list")
                .build().encode().toUri();
    }

    public CocktailListDto getRandomCocktail() {
        return restTemplate.getForObject(buildUrlRandomCocktail(), CocktailListDto.class);
    }

    public CocktailListDto getCocktailByName(String name) {
        return restTemplate.getForObject(buildUrlSearchCocktailByName(name), CocktailListDto.class);
    }

    public CocktailListDto getCocktailByMainIngredient(String ingredient) {
        return restTemplate.getForObject(buildUrlSearchByMainIngredient(ingredient), CocktailListDto.class);
    }

    public CocktailListDto getCocktailById(String id) {
        return restTemplate.getForObject(buildUrlSearchById(id), CocktailListDto.class);
    }

    public CocktailListDto getCategories() {
        return restTemplate.getForObject(buildUrlGetCategories(), CocktailListDto.class);
    }

    public CocktailListDto getIngredients() {
        return restTemplate.getForObject(buildUrlGetIngredients(), CocktailListDto.class);
    }
}
