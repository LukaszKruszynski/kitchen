package com.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idDrink",
        "strDrink",
        "strDrinkAlternate",
        "strDrinkES",
        "strDrinkDE",
        "strDrinkFR",
        "strDrinkZH-HANS",
        "strDrinkZH-HANT",
        "strTags",
        "strVideo",
        "strCategory",
        "strIBA",
        "strAlcoholic",
        "strGlass",
        "strInstructions",
        "strInstructionsES",
        "strInstructionsDE",
        "strInstructionsFR",
        "strInstructionsZH-HANS",
        "strInstructionsZH-HANT",
        "strDrinkThumb",
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
        "strCreativeCommonsConfirmed",
        "dateModified"
})
public class CocktailDto {

    @JsonProperty("idDrink")
    public String idDrink;
    @JsonProperty("strDrink")
    public String strDrink;
    @JsonProperty("strDrinkAlternate")
    public String strDrinkAlternate;
    @JsonProperty("strDrinkES")
    public String strDrinkES;
    @JsonProperty("strDrinkDE")
    public String strDrinkDE;
    @JsonProperty("strDrinkFR")
    public String strDrinkFR;
    @JsonProperty("strDrinkZH-HANS")
    public String strDrinkZHHANS;
    @JsonProperty("strDrinkZH-HANT")
    public String strDrinkZHHANT;
    @JsonProperty("strTags")
    public String strTags;
    @JsonProperty("strVideo")
    public String strVideo;
    @JsonProperty("strCategory")
    public String strCategory;
    @JsonProperty("strIBA")
    public String strIBA;
    @JsonProperty("strAlcoholic")
    public String strAlcoholic;
    @JsonProperty("strGlass")
    public String strGlass;
    @JsonProperty("strInstructions")
    public String strInstructions;
    @JsonProperty("strInstructionsES")
    public String strInstructionsES;
    @JsonProperty("strInstructionsDE")
    public String strInstructionsDE;
    @JsonProperty("strInstructionsFR")
    public String strInstructionsFR;
    @JsonProperty("strInstructionsZH-HANS")
    public String strInstructionsZHHANS;
    @JsonProperty("strInstructionsZH-HANT")
    public String strInstructionsZHHANT;
    @JsonProperty("strDrinkThumb")
    public String strDrinkThumb;
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
    @JsonProperty("strCreativeCommonsConfirmed")
    public String strCreativeCommonsConfirmed;
    @JsonProperty("dateModified")
    public String dateModified;
}