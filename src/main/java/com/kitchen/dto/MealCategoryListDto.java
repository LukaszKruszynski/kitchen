package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MealCategoryListDto {

    @JsonProperty("categories")
    private List<MealCategoryDto> categories = null;
}
