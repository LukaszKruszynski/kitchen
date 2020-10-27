package com.kitchen.repository;

import com.kitchen.domain.Fridge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends CrudRepository<Fridge,Long> {
    List<Fridge> findAll();

}
