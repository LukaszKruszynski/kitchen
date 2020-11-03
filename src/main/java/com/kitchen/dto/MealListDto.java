package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MealListDto {

    @JsonProperty("meals")
    private List<MealDto> meals;
}

