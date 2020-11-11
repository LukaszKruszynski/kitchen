package com.kitchen.cocktail.client;


import com.kitchen.cocktail.configuration.CocktailConfig;
import com.kitchen.dto.CocktailListDto;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static com.kitchen.dto.CocktailDtoBuilder.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CocktailClientTestSuite {

    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1";

    @InjectMocks
    private CocktailClient client;

    @Mock
    private CocktailConfig cocktailConfig;

    @Mock
    private RestTemplate restTemplate;

    private CocktailListDto cocktailListDtoOne;
    private CocktailListDto cocktailListDtoEmpty;
    private CocktailListDto cocktailListDtoTwo;


    @BeforeEach
    void setup() {
        cocktailListDtoEmpty = buildEmptyList();
        cocktailListDtoOne = buildExampleCocktail();
        cocktailListDtoTwo = buildExampleCocktails();
        when(cocktailConfig.getBasicUrl()).thenReturn(BASE_URL);
    }

    @Test
    void shouldGetMockObjectWithEmptyList() {
        //given
        when(restTemplate.getForObject(CocktailUrlBuilder.buildUrlGetCocktailById(cocktailConfig.getBasicUrl(),"123"), CocktailListDto.class)).thenReturn(cocktailListDtoEmpty);

        //when
        CocktailListDto actual = client.getCocktailById("123");

        //then
        Assert.assertEquals(0, actual.getCocktails().size());
    }

    @Test
    void shouldGetMockObjectContainsListWithOneCocktailObject() {
        //given
        when(restTemplate.getForObject(CocktailUrlBuilder.buildUrlGetRandomCocktail(cocktailConfig.getBasicUrl()), CocktailListDto.class)).thenReturn(cocktailListDtoOne);

        //when
        CocktailListDto actual = client.getRandomCocktail();

        //then
        Assert.assertEquals(1, actual.getCocktails().size());
    }

    @Test
    void shouldGetMockObjectContainsListWithMoreThanOneCocktailObjects() {
        //given
        when(restTemplate.getForObject(CocktailUrlBuilder.buildUrlGetCocktailsByName(cocktailConfig.getBasicUrl(), DRINK_NAME_TEST), CocktailListDto.class)).thenReturn(cocktailListDtoTwo);

        //when
        CocktailListDto actual = client.getCocktailByName(DRINK_NAME_TEST);

        //then
        Assert.assertEquals(2, actual.getCocktails().size());
        Assert.assertEquals("Malibu", actual.getCocktails().get(1).strDrink);
    }
}
