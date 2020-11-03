package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

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

    @BeforeEach
    public void init() {
        product1 = new Product.ProductBuilder()
                .barcode("2020123")
                .expiryDate(LocalDate.now())
                .name("Szynka")
                .note("Na kolacje")
                .quantity("pól kilo")
                .storageType(StorageType.FRIDGE)
                .build();

        product2 = new Product.ProductBuilder()
                .barcode("6574532")
                .expiryDate(LocalDate.now())
                .name("Ser")
                .note("Najlepiej gouda")
                .quantity("300g")
                .storageType(StorageType.FRIDGE)
                .build();

        product3 = new Product.ProductBuilder()
                .barcode("43265785")
                .expiryDate(LocalDate.now())
                .name("Frytki")
                .note("Karbowane")
                .quantity("paczka 2kg")
                .storageType(StorageType.FREEZER)
                .build();

        product4 = new Product.ProductBuilder()
                .barcode("4365785785")
                .expiryDate(LocalDate.now())
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
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);
        productService.saveProduct(product4);
        productService.saveProduct(product5);
        List<Product> resultList = productService.getProductsByName("Szynka");
        System.out.println(resultList);

        System.out.println("ss");
    }
}
