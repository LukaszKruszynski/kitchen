package com.kitchen.meal.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MealConfig {
    @Value("${meal.basic.url}")
    private String BasicUrl;
}
