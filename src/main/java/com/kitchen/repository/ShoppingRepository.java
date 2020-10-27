package com.kitchen.repository;

import com.kitchen.domain.Shopping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends CrudRepository<Shopping,Long> {
}
