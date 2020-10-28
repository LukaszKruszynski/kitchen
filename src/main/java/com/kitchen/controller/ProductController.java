package com.kitchen.controller;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.dto.ProductDto;
import com.kitchen.exception.ProductNotFoundException;
import com.kitchen.mapper.product.ProductMapper;
import com.kitchen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    ProductMapper mapper;

    @GetMapping
    public List<ProductDto> getProducts() {
        return mapper.mapToProductDtos(service.getProducts());
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable Long id) throws ProductNotFoundException {
        return mapper.mapToProductDto(service.getProduct(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(mapper.mapToProduct(productDto));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return mapper.mapToProductDto(service.saveProduct(mapper.mapToProduct(productDto)));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @GetMapping(value = "/freezer")
    public List<ProductDto> getProductsFreezer() {
        List<Product> products = service.getProducts();
        List<Product> filterProducts = products.stream()
                .filter(product -> product.getStorageType().equals(StorageType.FREEZER))
                .collect(Collectors.toList());
        return mapper.mapToProductDtos(filterProducts);
    }

    @GetMapping(value = "/fridge")
    public List<ProductDto> getProductsFridge() {
        List<Product> products = service.getProducts();
        List<Product> filterProducts = products.stream()
                .filter(product -> product.getStorageType().equals(StorageType.FRIDGE))
                .collect(Collectors.toList());
        return mapper.mapToProductDtos(filterProducts);

    }

    @GetMapping(value = "/pantry")
    public List<ProductDto> getProductsPantry() {
        List<Product> products = service.getProducts();
        List<Product> filterProducts = products.stream()
                .filter(product -> product.getStorageType().equals(StorageType.PANTRY))
                .collect(Collectors.toList());
        return mapper.mapToProductDtos(filterProducts);
    }

    @GetMapping(value = "/shopping")
    public List<ProductDto> getProductShopping() {
        List<Product> products = service.getProducts();
        List<Product> filterProducts = products.stream()
                .filter(product -> product.getStorageType().equals(StorageType.SHOPPING))
                .collect(Collectors.toList());
        return mapper.mapToProductDtos(filterProducts);
    }
}
