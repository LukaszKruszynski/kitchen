package com.kitchen.repository;

import com.kitchen.domain.Freezer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreezerRepository extends CrudRepository<Freezer,Long> {
}
