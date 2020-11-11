package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {

    public static List<Product> buildExampleProducts() {

        List<Product> products = new ArrayList<>();
        Product product1;
        Product product2;
        Product product3;
        Product product4;
        Product product5;
        Product product6;
        Product product7;
        Product product8;
        Product product9;
        Product product10;
        Product product11;
        Product product12;
        Product product13;
        Product product14;
        Product product15;
        Product product16;

        product1 = new Product.ProductBuilder()
                .barcode("2020123")
                .expiryDate(LocalDate.now())
                .name("Test entity developer product 1")
                .note("It's product 1 to test and keep this field unique 1")
                .quantity("test 1")
                .storageType(StorageType.FRIDGE)
                .build();

        product2 = new Product.ProductBuilder()
                .barcode("6574532")
                .expiryDate(LocalDate.now())
                .name("Test entity developer product 2")
                .note("It's product 2 to test and keep this field unique 2")
                .quantity("test 2")
                .storageType(StorageType.FREEZER)
                .build();

        product3 = new Product.ProductBuilder()
                .barcode("43265785")
                .expiryDate(LocalDate.now())
                .name("Test entity developer product 3")
                .note("It's product 3 to test and keep this field unique 3")
                .quantity("test 3")
                .storageType(StorageType.PANTRY)
                .build();

        product4 = new Product.ProductBuilder()
                .barcode("4365785785")
                .expiryDate(LocalDate.now())
                .name("Test entity developer product 4")
                .note("It's product 4 to test and keep this field unique 4")
                .quantity("test 4")
                .storageType(StorageType.SHOPPING)
                .build();

        product5 = new Product.ProductBuilder()
                .barcode("5902193484")
                .expiryDate(LocalDate.now())
                .name("marchew")
                .quantity("2kg")
                .storageType(StorageType.PANTRY)
                .build();

        product6 = new Product.ProductBuilder()
                .name("Ziemniaki")
                .quantity("10kg")
                .storageType(StorageType.PANTRY)
                .build();

        product7 = new Product.ProductBuilder()
                .name("wódka")
                .quantity("0.7l")
                .storageType(StorageType.FREEZER)
                .build();

        product8 = new Product.ProductBuilder()
                .name("coca-cola")
                .quantity("1.5l")
                .storageType(StorageType.SHOPPING)
                .build();

        product9 = new Product.ProductBuilder()
                .id(12345l)
                .name("kinder bueno")
                .quantity("3 szt.")
                .storageType(StorageType.SHOPPING)
                .build();

        product10 = new Product.ProductBuilder()
                .name("Pierś z kurczaka")
                .quantity("2kg")
                .storageType(StorageType.FREEZER)
                .build();

        product11 = new Product.ProductBuilder()
                .name("Jaja")
                .quantity("20szt")
                .storageType(StorageType.FRIDGE)
                .build();

        product12 = new Product.ProductBuilder()
                .name("Cebula")
                .quantity("3kg")
                .storageType(StorageType.PANTRY)
                .build();

        product13 = new Product.ProductBuilder()
                .name("Kawa")
                .quantity("3kg")
                .storageType(StorageType.PANTRY)
                .build();

        product14 = new Product.ProductBuilder()
                .name("Jogurt 200ml")
                .quantity("4szt")
                .storageType(StorageType.FRIDGE)
                .build();

        product15 = new Product.ProductBuilder()
                .name("Sok pomarańczowy 1L")
                .quantity("6 szt.")
                .storageType(StorageType.SHOPPING)
                .build();

        product16 = new Product.ProductBuilder()
                .name("Papier Toaletowy")
                .quantity("20 szt.")
                .storageType(StorageType.SHOPPING)
                .build();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
        products.add(product11);
        products.add(product12);
        products.add(product13);
        products.add(product14);
        products.add(product15);
        products.add(product16);

        return products;
    }


}
