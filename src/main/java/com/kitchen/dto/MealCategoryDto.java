package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idCategory",
        "strCategory",
        "strCategoryThumb",
        "strCategoryDescription"
})
public class MealCategoryDto {

    @JsonProperty("idCategory")
    private String idCategory;
    @JsonProperty("strCategory")
    private String strCategory;
    @JsonProperty("strCategoryThumb")
    private String strCategoryThumb;
    @JsonProperty("strCategoryDescription")
    private String strCategoryDescription;
}
