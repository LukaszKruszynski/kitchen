package com.kitchen.controller;

import com.kitchen.dto.ProductDto;
import com.kitchen.exception.ProductNotFoundException;
import com.kitchen.mapper.product.ProductMapper;
import com.kitchen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/fridge")
    public List<ProductDto> getProductsFridge() {
        return mapper.mapToProductDtos(service.getProductsFridge());
    }

    @GetMapping(value = "/freezer")
    public List<ProductDto> getProductsFreezer() {
        return mapper.mapToProductDtos(service.getProductsFreezer());
    }

    @GetMapping(value = "/pantry")
    public List<ProductDto> getProductsPantry() {
        return mapper.mapToProductDtos(service.getProductsPantry());
    }

    @GetMapping(value = "/shopping")
    public List<ProductDto> getProductShopping() {
        return mapper.mapToProductDtos(service.getProductsShopping());
    }

    @GetMapping(value = "/exp/today")
    public List<ProductDto> getProductsExpiryDateEndsToday() {
        return mapper.mapToProductDtos(service.getProductsWithExpireDateEndsToday());
    }

    @GetMapping(value ="fridge/search/{name}")
    public List<ProductDto> getFridgeProductsByNameContains(@PathVariable String name) {
        return mapper.mapToProductDtos(service.getFridgeProductsByNameContains(name));
    }

    @GetMapping(value ="freezer/search/{name}")
    public List<ProductDto> getFreezerProductsByNameContains(@PathVariable String name) {
        return mapper.mapToProductDtos(service.getFreezerProductsByNameContains(name));
    }

    @GetMapping(value ="pantry/search/{name}")
    public List<ProductDto> getPantryProductsByNameContains(@PathVariable String name) {
        return mapper.mapToProductDtos(service.getPantryProductsByNameContains(name));
    }

    @GetMapping(value ="shopping/search/{name}")
    public List<ProductDto> getShoppingProductsByNameContains(@PathVariable String name) {
        return mapper.mapToProductDtos(service.getShoppingProductsByNameContains(name));
    }


}
