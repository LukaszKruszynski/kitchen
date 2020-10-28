package com.kitchen.themeal.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TheMealConfig {
    @Value("${meal.basic.url}")
    private String BasicUrl;
}
