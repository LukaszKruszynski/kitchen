package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

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
    private Product product6;
    private Product product7;
    private Product product8;
    private Product product9;
    private Product product10;
    private Product product11;
    private Product product12;
    private Product product13;
    private Product product14;
    private Product product15;
    private Product product16;

    @BeforeEach
    public void init() {
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
    }

    @Test
    public void shouldSaveProduct() {
        //Given in init()
        //When
        productService.saveProduct(product1);
        List<Product> products = productRepository.findByName("Test entity developer product 1");
        List<Product> filterProducts = products.stream()
                .filter(p -> p.getNote().equals("It's product 1 to test and keep this field unique 1"))
                .collect(Collectors.toList());
        //Then
        assertFalse(filterProducts.isEmpty());
        assertEquals(1, filterProducts.size());
        assertEquals("Test entity developer product 1", filterProducts.get(0).getName());
        assertEquals("It's product 1 to test and keep this field unique 1", filterProducts.get(0).getNote());
        //Clean Up
        productService.deleteProduct(filterProducts.get(0).getId());
    }

    @Test
    public void shouldGetProduct() {
        //Given in init()
        //When
        productService.saveProduct(product1);
        List<Product> products = productRepository.findByName("Test entity developer product 1");
        Long id = products.get(0).getId();
        Optional<Product> product = productService.getProduct(id);
        //Then
        assertTrue(product.isPresent());
        assertEquals("It's product 1 to test and keep this field unique 1", product.get().getNote());
        //Clean Up
        productService.deleteProduct(product.get().getId());
    }

    @Test
    public void shouldGetProducts() {
        //When in init()
        //Given
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        List<Product> products = productService.getProducts();
        List<Product> products1 = products.stream()
                .filter(p -> p.getNote().equals("It's product 1 to test and keep this field unique 1"))
                .collect(Collectors.toList());
        List<Product> products2 = products.stream()
                .filter(p -> p.getNote().equals("It's product 2 to test and keep this field unique 2"))
                .collect(Collectors.toList());
        boolean isAdded = products1.addAll(products2);
        //Then
        assertTrue(isAdded);
        assertEquals(2, products1.size());
        assertEquals("It's product 1 to test and keep this field unique 1", products1.get(0).getNote());
        assertEquals("It's product 2 to test and keep this field unique 2", products1.get(1).getNote());
        //Clean Up
        productService.deleteProduct(products1.get(0).getId());
        productService.deleteProduct(products1.get(1).getId());
    }

    @Test
    public void shouldGetProductsWithExpiryDateEndsToday() {
        //When in init()
        //Given
        productService.saveProduct(product1);
        List<Product> products = productService.getProductsWithExpireDateEndsToday();
        //Then
        assertFalse(products.isEmpty());
        assertTrue(products.contains(product1));
        assertEquals(LocalDate.now(), products.get(0).getExpiryDate());
        //Clean up
        List<Product> cleanUpList = products.stream()
                .filter(p -> p.getNote().equals("It's product 1 to test and keep this field unique 1"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetProductFridge() {
        //When in init()
        //Given
        productService.saveProduct(product1);
        List<Product> productsFridge = productService.getProductsFridge();
        //Then
        productsFridge.forEach(p -> assertEquals(StorageType.FRIDGE, p.getStorageType()));
        //Clean up
        List<Product> cleanUpList = productsFridge.stream()
                .filter(p -> p.getNote().equals("It's product 1 to test and keep this field unique 1"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetProductFreezer() {
        ///When in init()
        //Given
        productService.saveProduct(product2);
        List<Product> productsFreezer = productService.getProductsFreezer();
        //Then
        productsFreezer.forEach(p -> assertEquals(StorageType.FREEZER, p.getStorageType()));
        //Clean Up
        List<Product> cleanUpList = productsFreezer.stream()
                .filter(p -> p.getNote().equals("It's product 2 to test and keep this field unique 2"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetProductPantry() {
        //When in init()
        //Given
        productService.saveProduct(product3);
        List<Product> productsPantry = productService.getProductsPantry();
        //Then
        productsPantry.forEach(p -> assertEquals(StorageType.PANTRY, p.getStorageType()));
        //Clean Up
        List<Product> cleanUpList = productsPantry.stream()
                .filter(p -> p.getNote().equals("It's product 3 to test and keep this field unique 3"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetProductShopping() {
        //When in init()
        //Given
        productService.saveProduct(product4);
        List<Product> productsShopping = productService.getProductsShopping();
        //Then
        productsShopping.forEach(p -> assertEquals(StorageType.SHOPPING, p.getStorageType()));
        //Clean Up
        List<Product> cleanUpList = productsShopping.stream()
                .filter(p -> p.getNote().equals("It's product 4 to test and keep this field unique 4"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetFridgeProductsByNameContains() {
        //When in init()
        //Given
        productService.saveProduct(product1);
        List<Product> products = productService.getFridgeProductsByNameContains("1");
        //Then
        products.forEach(p -> assertTrue(p.getName().contains("1")));
        //Clean up
        List<Product> cleanUpList = products.stream()
                .filter(p -> p.getNote().equals("It's product 1 to test and keep this field unique 1"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetFreezerProductsByNameContains() {
        //When in init()
        //Given
        productService.saveProduct(product2);
        List<Product> products = productService.getFreezerProductsByNameContains("2");
        //Then
        products.forEach(p -> assertTrue(p.getName().contains("2")));
        //Clean up
        List<Product> cleanUpList = products.stream()
                .filter(p -> p.getNote().equals("It's product 2 to test and keep this field unique 2"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetPantryProductsByNameContains() {
        //When in init()
        //Given
        productService.saveProduct(product3);
        List<Product> products = productService.getPantryProductsByNameContains("3");
        //Then
        products.forEach(p -> assertTrue(p.getName().contains("3")));
        //Clean up
        List<Product> cleanUpList = products.stream()
                .filter(p -> p.getNote().equals("It's product 3 to test and keep this field unique 3"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }

    @Test
    public void shouldGetShoppingProductsByNameContains() {
        //When in init()
        //Given
        productService.saveProduct(product4);
        List<Product> products = productService.getShoppingProductsByNameContains("4");
        //Then
        products.forEach(p -> assertTrue(p.getName().contains("4")));
        //Clean up
        List<Product> cleanUpList = products.stream()
                .filter(p -> p.getNote().equals("It's product 4 to test and keep this field unique 4"))
                .collect(Collectors.toList());
        productService.deleteProduct(cleanUpList.get(0).getId());
    }
}
