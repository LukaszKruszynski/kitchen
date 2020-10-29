package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ProductServiceTestSuite {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    @Before
    void init() {

        product1 = new Product.ProductBuilder()
                .barcode("2020123")
                .expiryDate(LocalDate.of(2020, 10, 31))
                .name("Szynka")
                .note("Na kolacje")
                .quantity("pól kilo")
                .storageType(StorageType.FRIDGE)
                .build();

        product2 = new Product.ProductBuilder()
                .barcode("6574532")
                .expiryDate(LocalDate.of(2020, 11, 2))
                .name("Ser")
                .note("Najlepiej gouda")
                .quantity("300g")
                .storageType(StorageType.FRIDGE)
                .build();

        product3 = new Product.ProductBuilder()
                .barcode("43265785")
                .expiryDate(LocalDate.of(2021, 8, 15))
                .name("Frytki")
                .note("Karbowane")
                .quantity("paczka 2kg")
                .storageType(StorageType.FREEZER)
                .build();

        product4 = new Product.ProductBuilder()
                .barcode("4365785785")
                .expiryDate(LocalDate.of(2022, 8, 10))
                .name("kukurydza")
                .note("w puszce")
                .quantity("400g")
                .storageType(StorageType.PANTRY)
                .build();

        product5 = new Product.ProductBuilder()
                .name("Pomidory")
                .note("Malinowe")
                .quantity("1kg")
                .storageType(StorageType.SHOPPING)
                .build();

    }
    @Test
    void test() {
        Product newProduct = new Product();
        newProduct.setStorageType(StorageType.PANTRY);
        newProduct.setQuantity("to");
        newProduct.setNote("chyba");
        newProduct.setName("dziala");
        newProduct.setExpiryDate(LocalDate.now());
        newProduct.setBarcode("1234567");

//        productRepository.save(newProduct);
        System.out.println("hello word");
    }
}
