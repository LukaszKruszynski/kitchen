package com.kitchen.mapper.product;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.dto.ProductDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {
    static Product returnExampleProduct() {
        return new Product.ProductBuilder()
                .id(1l)
                .name("test")
                .storageType(StorageType.FRIDGE)
                .expiryDate(LocalDate.of(2020, 11, 11))
                .note("test note")
                .quantity("one")
                .barcode("123456789")
                .build();
    }

    static ProductDto returnExampleProductDto() {
        return new ProductDto.ProductDtoBuilder()
                .id(2l)
                .name("test dto")
                .storageType(StorageType.FREEZER)
                .expiryDate(LocalDate.of(2020, 10, 10))
                .note("test note dto")
                .quantity("one dto")
                .barcode("54321")
                .build();
    }

    static List<Product> returnExampleProducts() {
        List<Product> products = new ArrayList<>();
        Product secondProduct = returnExampleProduct();
        secondProduct.setId(2l);
        products.add(returnExampleProduct());
        products.add(secondProduct);
        return products;
    }

    static List<ProductDto> returnExampleProductsDtos() {
        List<ProductDto> products = new ArrayList<>();
        ProductDto secondProductDto = returnExampleProductDto();
        secondProductDto.setId(2l);
        products.add(returnExampleProductDto());
        products.add(secondProductDto);
        return products;
    }
}
