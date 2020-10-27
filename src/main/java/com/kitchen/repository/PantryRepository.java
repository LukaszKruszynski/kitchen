package com.kitchen.repository;

import com.kitchen.domain.Pantry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantryRepository extends CrudRepository<Pantry,Long> {
}
