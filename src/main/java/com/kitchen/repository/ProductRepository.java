package com.kitchen.repository;

import com.kitchen.domain.Fridge;
import com.kitchen.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    @Override
    List<Product> findAll();

    List<Product> findByFridge(final Fridge fridge);
}
