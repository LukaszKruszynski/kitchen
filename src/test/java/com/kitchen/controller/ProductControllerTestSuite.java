package com.kitchen.controller;

import com.google.gson.Gson;
import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.dto.ProductDto;
import com.kitchen.mapper.product.ProductMapper;
import com.kitchen.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductControllerTestSuite {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService service;

    @MockBean
    ProductMapper productMapper;

    @Test
    void shouldGetProducts() throws Exception {
        //Given
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(10l, "Product", "10kg", "to dinner",
                "5903176314", LocalDate.of(2020, 10, 05), StorageType.FRIDGE));
        List<Product> products = new ArrayList<>();
        products.add(new Product(10l, "Product", "10kg", "to dinner",
                "5903176314", LocalDate.of(2020, 10, 05), StorageType.FRIDGE));
        when(service.getProducts()).thenReturn(products);
        when(productMapper.mapToProductsDtos(products)).thenReturn(productDtos);
        //When & Then
        mockMvc.perform(get("/v1/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(10)))
                .andExpect(jsonPath("$[0].name", is("Product")))
                .andExpect(jsonPath("$[0].quantity", is("10kg")))
                .andExpect(jsonPath("$[0].note", is("to dinner")))
                .andExpect(jsonPath("$[0].barcode", is("5903176314")))
                .andExpect(jsonPath("$[0].expiryDate", is("2020-10-05")))
                .andExpect(jsonPath("$[0].storageType", is("FRIDGE")));
        verify(service, times(1)).getProducts();
        verify(productMapper, times(1)).mapToProductsDtos(anyList());
    }

    @Test
    void shouldGetProduct() throws Exception {
        //Given
        ProductDto productDto = new ProductDto(10l, "Product", "10kg", "to dinner",
                "5903176314", LocalDate.of(2020, 10, 05), StorageType.FRIDGE);
        Product product = new Product(10l, "Product", "10kg", "to dinner",
                "5903176314", LocalDate.of(2020, 10, 05), StorageType.FRIDGE);
        when(service.getProduct(anyLong())).thenReturn(Optional.of(product));
        when(productMapper.mapToProductDto(product)).thenReturn(productDto);
        //When & Then
        mockMvc.perform(get("/v1/products/{id}", 10l).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(10)))
                .andExpect(jsonPath("$.name", is("Product")))
                .andExpect(jsonPath("$.quantity", is("10kg")))
                .andExpect(jsonPath("$.note", is("to dinner")))
                .andExpect(jsonPath("$.barcode", is("5903176314")))
                .andExpect(jsonPath("$.expiryDate", is("2020-10-05")))
                .andExpect(jsonPath("$.storageType", is("FRIDGE")));
        verify(service, times(1)).getProduct(anyLong());
        verify(productMapper, times(1)).mapToProductDto(any(Product.class));
    }

    @Test
    void shouldDeleteProduct() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(delete("/v1/products/{id}", 10l).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service, times(1)).deleteProduct(10l);
    }

    @Test
    void shouldUpdateProduct() throws Exception {
//        //Given
//        Product productToUpdate = new Product(10l, "Product", "10kg", "to dinner",
//                "5903176314", LocalDate.of(2020, 10, 05), StorageType.FRIDGE);
//        ProductDto productDtoToUpdate = new ProductDto(10l, "Product", "10kg", "to dinner",
//                "5903176314", LocalDate.of(2020, 10, 05), StorageType.FRIDGE);
//        Gson gson = new Gson();
//        String productToUpdateJson = gson.toJson(productToUpdate);
//        when(productMapper.mapToProduct(any(ProductDto.class))).thenReturn(productToUpdate);
//        when(productMapper.mapToProductDto(any(Product.class))).thenReturn(productDtoToUpdate);
//        when(service.saveProduct(any(Product.class))).thenReturn(productToUpdate);
//        //When & Given
//        mockMvc.perform(MockMvcRequestBuilders.put("/v1/products").contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(productToUpdateJson))
//                .andExpect(ResultMatcher.matchAll(
//                        status().isOk(),
//                        (jsonPath("$.id", is(10))),
//                        (jsonPath("$.name", is("Product"))),
//                        (jsonPath("$.quantity", is("10kg"))),
//                        (jsonPath("$.note", is("to dinner"))),
//                        (jsonPath("$.barcode", is("5903176314"))),
//                        (jsonPath("$.expiryDate", is("2020-10-05"))),
//                        (jsonPath("$.storageType", is("Fridge")))
//                ));
//        verify(service.getProduct(anyLong()), times(1));
//        verify(productMapper.mapToProduct(any(ProductDto.class)), times(1));
//        verify(productMapper.mapToProductDto(any(Product.class)), times(1));
    }
}