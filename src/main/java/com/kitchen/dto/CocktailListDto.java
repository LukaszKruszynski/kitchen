package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CocktailListDto {
    @JsonProperty("drinks")
    List<CocktailDto> cocktails;
}
