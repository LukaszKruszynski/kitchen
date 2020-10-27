package com.kitchen.manager.product;

import com.kitchen.domain.Fridge;
import com.kitchen.domain.Product;
import com.kitchen.repository.FridgeRepository;
import com.kitchen.repository.ProductRepository;
import com.kitchen.service.FreezerService;
import com.kitchen.service.FridgeService;
import com.kitchen.service.PantryService;
import com.kitchen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManagerImpl implements Manager {
    @Autowired
    FreezerService freezerService;

    @Autowired
    FridgeService fridgeService;

    @Autowired
    FridgeRepository fridgeRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PantryService pantryService;

    @Override
    public void moveProduct(Object from, Object to, Product product) {
        if (from.getClass().equals(Fridge.class)) {
            List<Product> byFridge = productRepository.findByFridge((Fridge) from);
            if(byFridge.contains(product)) {
                productRepository.delete(product);
            }
        }
    }
}

