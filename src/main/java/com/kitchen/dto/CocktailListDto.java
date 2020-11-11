package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CocktailListDto {
    @JsonProperty("drinks")
    List<CocktailDto> cocktails;
}
