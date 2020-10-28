package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.domain.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ProductServiceTestSuite {
    @Autowired
    private ProductService productService;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;
    private User user;

    @Before
    private void init() {

        product1 = new Product.ProductBuilder()
                .id(1l)
                .barcode(2020123l)
                .expiryDate(LocalDate.of(2020, 10, 31))
                .name("Szynka")
                .note("Na kolacje")
                .quantity("pól kilo")
                .storageType(StorageType.FRIDGE)
                .build();

        product2 = new Product.ProductBuilder()
                .id(2l)
                .barcode(6574532l)
                .expiryDate(LocalDate.of(2020, 11, 2))
                .name("Ser")
                .note("Najlepiej gouda")
                .quantity("300g")
                .storageType(StorageType.FRIDGE)
                .build();

        product3 = new Product.ProductBuilder()
                .id(3l)
                .barcode(43265785l)
                .expiryDate(LocalDate.of(2021, 8, 15))
                .name("Frytki")
                .note("Karbowane")
                .quantity("paczka 2kg")
                .storageType(StorageType.FREEZER)
                .build();

        product4 = new Product.ProductBuilder()
                .id(3l)
                .barcode(4365785785l)
                .expiryDate(LocalDate.of(2022, 8, 10))
                .name("kukurydza")
                .note("w puszce")
                .quantity("400g")
                .storageType(StorageType.PANTRY)
                .build();

        product5 = new Product.ProductBuilder()
                .id(3l)
                .name("Pomidory")
                .note("Malinowe")
                .quantity("1kg")
                .storageType(StorageType.SHOPPING)
                .build();

    }
    @Test
    public void test() {
        System.out.println("hello word");
    }
}
