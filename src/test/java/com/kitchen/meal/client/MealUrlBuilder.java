package com.kitchen.meal.client;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

class MealUrlBuilder {
    static URI buildUrlSearchById(String id, String basicUrl) {
        return UriComponentsBuilder.fromHttpUrl(basicUrl+ "/lookup.php?i=" + id)
                .build().encode().toUri();
    }

    static URI buildUrlGetRandomMeal(String basicUrl) {
        return UriComponentsBuilder.fromHttpUrl(basicUrl + "/random.php")
                .build().encode().toUri();
    }

    static URI buildUrlGetMealsByName(String basicUrl, String name) {
        return UriComponentsBuilder.fromHttpUrl(basicUrl + "/search.php?s=" + name)
                .build().encode().toUri();
    }

}