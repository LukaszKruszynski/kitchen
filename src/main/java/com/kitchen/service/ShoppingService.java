package com.kitchen.service;

import com.kitchen.domain.Shopping;
import com.kitchen.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {
    @Autowired
    ShoppingRepository repository;

    public Shopping saveShopping(final Shopping shopping) {
        return repository.save(shopping);
    }

    public void deleteShopping(final Shopping shopping) {
        repository.delete(shopping);
    }
}
