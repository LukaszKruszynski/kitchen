package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idMeal",
        "strMeal",
        "strDrinkAlternate",
        "strCategory",
        "strArea",
        "strInstructions",
        "strMealThumb",
        "strTags",
        "strYoutube",
        "strIngredient1",
        "strIngredient2",
        "strIngredient3",
        "strIngredient4",
        "strIngredient5",
        "strIngredient6",
        "strIngredient7",
        "strIngredient8",
        "strIngredient9",
        "strIngredient10",
        "strIngredient11",
        "strIngredient12",
        "strIngredient13",
        "strIngredient14",
        "strIngredient15",
        "strIngredient16",
        "strIngredient17",
        "strIngredient18",
        "strIngredient19",
        "strIngredient20",
        "strMeasure1",
        "strMeasure2",
        "strMeasure3",
        "strMeasure4",
        "strMeasure5",
        "strMeasure6",
        "strMeasure7",
        "strMeasure8",
        "strMeasure9",
        "strMeasure10",
        "strMeasure11",
        "strMeasure12",
        "strMeasure13",
        "strMeasure14",
        "strMeasure15",
        "strMeasure16",
        "strMeasure17",
        "strMeasure18",
        "strMeasure19",
        "strMeasure20",
        "strSource",
        "dateModified"
})
public class MealDto {

    @JsonProperty("idMeal")
    public String idMeal;
    @JsonProperty("strMeal")
    public String strMeal;
    @JsonProperty("strDrinkAlternate")
    public Object strDrinkAlternate;
    @JsonProperty("strCategory")
    public String strCategory;
    @JsonProperty("strArea")
    public String strArea;
    @JsonProperty("strInstructions")
    public String strInstructions;
    @JsonProperty("strMealThumb")
    public String strMealThumb;
    @JsonProperty("strTags")
    public String strTags;
    @JsonProperty("strYoutube")
    public String strYoutube;
    @JsonProperty("strIngredient1")
    public String strIngredient1;
    @JsonProperty("strIngredient2")
    public String strIngredient2;
    @JsonProperty("strIngredient3")
    public String strIngredient3;
    @JsonProperty("strIngredient4")
    public String strIngredient4;
    @JsonProperty("strIngredient5")
    public String strIngredient5;
    @JsonProperty("strIngredient6")
    public String strIngredient6;
    @JsonProperty("strIngredient7")
    public String strIngredient7;
    @JsonProperty("strIngredient8")
    public String strIngredient8;
    @JsonProperty("strIngredient9")
    public String strIngredient9;
    @JsonProperty("strIngredient10")
    public String strIngredient10;
    @JsonProperty("strIngredient11")
    public String strIngredient11;
    @JsonProperty("strIngredient12")
    public String strIngredient12;
    @JsonProperty("strIngredient13")
    public String strIngredient13;
    @JsonProperty("strIngredient14")
    public String strIngredient14;
    @JsonProperty("strIngredient15")
    public String strIngredient15;
    @JsonProperty("strIngredient16")
    public String strIngredient16;
    @JsonProperty("strIngredient17")
    public String strIngredient17;
    @JsonProperty("strIngredient18")
    public String strIngredient18;
    @JsonProperty("strIngredient19")
    public String strIngredient19;
    @JsonProperty("strIngredient20")
    public String strIngredient20;
    @JsonProperty("strMeasure1")
    public String strMeasure1;
    @JsonProperty("strMeasure2")
    public String strMeasure2;
    @JsonProperty("strMeasure3")
    public String strMeasure3;
    @JsonProperty("strMeasure4")
    public String strMeasure4;
    @JsonProperty("strMeasure5")
    public String strMeasure5;
    @JsonProperty("strMeasure6")
    public String strMeasure6;
    @JsonProperty("strMeasure7")
    public String strMeasure7;
    @JsonProperty("strMeasure8")
    public String strMeasure8;
    @JsonProperty("strMeasure9")
    public String strMeasure9;
    @JsonProperty("strMeasure10")
    public String strMeasure10;
    @JsonProperty("strMeasure11")
    public String strMeasure11;
    @JsonProperty("strMeasure12")
    public String strMeasure12;
    @JsonProperty("strMeasure13")
    public String strMeasure13;
    @JsonProperty("strMeasure14")
    public String strMeasure14;
    @JsonProperty("strMeasure15")
    public String strMeasure15;
    @JsonProperty("strMeasure16")
    public String strMeasure16;
    @JsonProperty("strMeasure17")
    public String strMeasure17;
    @JsonProperty("strMeasure18")
    public String strMeasure18;
    @JsonProperty("strMeasure19")
    public String strMeasure19;
    @JsonProperty("strMeasure20")
    public String strMeasure20;
    @JsonProperty("strSource")
    public String strSource;
    @JsonProperty("dateModified")
    public String dateModified;
}
