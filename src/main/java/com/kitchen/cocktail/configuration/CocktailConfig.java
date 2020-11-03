package com.kitchen.cocktail.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CocktailConfig {
    @Value("${cocktail.basic.url}")
    private String basicUrl;
}
