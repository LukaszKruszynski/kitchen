package com.kitchen.service;

import com.kitchen.domain.Product;
import com.kitchen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
