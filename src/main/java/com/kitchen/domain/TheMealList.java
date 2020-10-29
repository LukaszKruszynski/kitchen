package com.kitchen.domain;

import com.kitchen.dto.TheMealDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TheMealList {
    private List<TheMealDto> meals;

    public TheMealList(List<TheMealDto> meals) {
        this.meals = new ArrayList<>();
    }
}
