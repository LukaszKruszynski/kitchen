package com.kitchen.cocktail.client;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

class CocktailUrlBuilder {

    static URI buildUrlGetCocktailById(String basicUrl, String id) {
        return UriComponentsBuilder.fromHttpUrl(basicUrl + "/lookup.php?i=" + id)
                .build().encode().toUri();
    }

    static URI buildUrlGetRandomCocktail(String basicUrl) {
        return UriComponentsBuilder.fromHttpUrl(basicUrl + "/random.php")
                .build().encode().toUri();
    }

    static URI buildUrlGetCocktailsByName(String basicUrl, String name) {
        return UriComponentsBuilder.fromHttpUrl(basicUrl + "/search.php?s=" + name)
                .build().encode().toUri();
    }
}
