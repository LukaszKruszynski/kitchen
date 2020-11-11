package com.kitchen.meal.client;

import com.kitchen.dto.MealListDto;
import com.kitchen.meal.configuration.MealConfig;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static com.kitchen.dto.MealDtoBuilder.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealClientTestSuite {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1";

    @InjectMocks
    private MealClient client;

    @Mock
    private MealConfig mealConfig;

    @Mock
    private RestTemplate restTemplate;

    private MealListDto mealListDtoOne;
    private MealListDto mealListDtoEmpty;
    private MealListDto mealListDtoTwo;

    @BeforeEach
    void setup() {
        mealListDtoEmpty = buildEmptyList();
        mealListDtoOne = buildExampleMeal();
        mealListDtoTwo = buildExampleMeals();
        when(mealConfig.getBasicUrl()).thenReturn(BASE_URL);
    }

    @Test
    void shouldReturnMockObjectWithEmptyList() {

        //given
        final String ID = "2";
        when(restTemplate.getForObject(MealUrlBuilder.buildUrlSearchById(ID, mealConfig.getBasicUrl()), MealListDto.class)).thenReturn(mealListDtoEmpty);

        //when
        MealListDto actual = client.getMealById(ID);

        //then
        Assert.assertEquals(0, actual.getMeals().size());
    }

    @Test
    void shouldGetMockObjectContainsListWithOneMealObject() {
        //given
        when(restTemplate.getForObject(MealUrlBuilder.buildUrlGetRandomMeal(mealConfig.getBasicUrl()), MealListDto.class)).thenReturn(mealListDtoOne);

        //when
        MealListDto actual = client.getRandomMeal();

        //then
        Assert.assertEquals(1, actual.getMeals().size());
    }

    @Test
    void shouldGetMockObjectContainsListWithMoreThanOneMealObjects() {
        //given
        when(restTemplate.getForObject(MealUrlBuilder.buildUrlGetMealsByName(mealConfig.getBasicUrl(), MEAL_NAME_TEST), MealListDto.class)).thenReturn(mealListDtoTwo);

        //when
        MealListDto actual = client.getMealByName(MEAL_NAME_TEST);

        //then
        Assert.assertEquals(2, actual.getMeals().size());
        Assert.assertEquals("Chicken", actual.getMeals().get(1).strMeal);
    }
}
