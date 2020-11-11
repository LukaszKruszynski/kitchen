package com.kitchen.mapper.product;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static com.kitchen.mapper.product.ProductBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ProductMapperTestSuite {
    private Product product;
    private ProductDto productDto;
    private List<Product> products;
    private List<ProductDto> productsDtos;
    private ProductMapper productMapper = new ProductMapper();

    @BeforeEach
    void init() {
        //Given
        product = returnExampleProduct();
        productDto = returnExampleProductDto();
        products = returnExampleProducts();
        productsDtos = returnExampleProductsDtos();
    }

    @Test
    public void shouldMapToProduct() {
        //when
        Product actual = productMapper.mapToProduct(productDto);
        //then
        assertEquals("test dto", actual.getName());
        assertEquals(StorageType.FREEZER, actual.getStorageType());
        assertEquals(LocalDate.of(2020, 10, 10), actual.getExpiryDate());
        assertEquals("test note dto", actual.getNote());
        assertEquals("one dto", actual.getQuantity());
        assertEquals("54321", actual.getBarcode());
    }

    @Test
    public void shouldMapToProductDto() {
        //when
        ProductDto actual = productMapper.mapToProductDto(product);
        //then
        assertEquals("test", actual.getName());
        assertEquals(StorageType.FRIDGE, actual.getStorageType());
        assertEquals(LocalDate.of(2020, 11, 11), actual.getExpiryDate());
        assertEquals("test note", actual.getNote());
        assertEquals("one", actual.getQuantity());
        assertEquals("123456789", actual.getBarcode());
    }

    @Test
    public void shouldMapToProducts() {
        //when
        List<Product> products = productMapper.mapToProducts(productsDtos);
        //then
        assertTrue(products.size() > 1);
    }

    @Test
    public void shouldMapToProductsDtos() {
        //when
        List<ProductDto> productsDtos = productMapper.mapToProductsDtos(products);
        //then
        assertTrue(productsDtos.size() > 1);
    }
}