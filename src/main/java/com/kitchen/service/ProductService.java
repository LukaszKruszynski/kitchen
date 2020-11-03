package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.domain.StorageType;
import com.kitchen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(final Product product) {
        return repository.save(product);
    }

    public void deleteProduct(final Long id) {
        repository.deleteById(id);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProduct(final Long id) {
        return repository.findById(id);
    }

    public List<Product> getProductsWithExpireDateEndsToday() {
        return getProducts().stream()
                .filter(p -> p.getExpiryDate().equals(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsFridge() {
        return this.getProducts().stream()
                .filter(product -> product.getStorageType().equals(StorageType.FRIDGE))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsFreezer() {
        return this.getProducts().stream()
                .filter(product -> product.getStorageType().equals(StorageType.FREEZER))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsPantry() {
        return this.getProducts().stream()
                .filter(product -> product.getStorageType().equals(StorageType.PANTRY))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsShopping() {
        return this.getProducts().stream()
                .filter(product -> product.getStorageType().equals(StorageType.SHOPPING))
                .collect(Collectors.toList());
    }

    public List<Product> getFridgeProductsByNameContains(final String name) {
        List<Product> allByNameContains = repository.findAllByNameContains(name);
        return allByNameContains.stream()
                .filter(p -> p.getStorageType().equals(StorageType.FRIDGE))
                .collect(Collectors.toList());
    }

    public List<Product> getFreezerProductsByNameContains(final String name) {
        List<Product> allByNameContains = repository.findAllByNameContains(name);
        return allByNameContains.stream()
                .filter(p -> p.getStorageType().equals(StorageType.FREEZER))
                .collect(Collectors.toList());
    }

    public List<Product> getPantryProductsByNameContains(final String name) {
        List<Product> allByNameContains = repository.findAllByNameContains(name);
        return allByNameContains.stream()
                .filter(p -> p.getStorageType().equals(StorageType.PANTRY))
                .collect(Collectors.toList());
    }

    public List<Product> getShoppingProductsByNameContains(final String name) {
        List<Product> allByNameContains = repository.findAllByNameContains(name);
        return allByNameContains.stream()
                .filter(p -> p.getStorageType().equals(StorageType.SHOPPING))
                .collect(Collectors.toList());
    }
}
