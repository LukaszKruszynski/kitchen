package com.kitchen.service;

import com.kitchen.domain.Pantry;
import com.kitchen.repository.PantryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PantryService {
    @Autowired
    PantryRepository repository;

    public Pantry savePantry(final Pantry pantry) {
        return repository.save(pantry);
    }
    public void deletePantry(final Pantry pantry) {
        repository.delete(pantry);
    }
}
