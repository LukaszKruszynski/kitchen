package com.kitchen.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Long id) {
        super(String.format("Product with given ID: [%d] not found" , id));
    }
}
