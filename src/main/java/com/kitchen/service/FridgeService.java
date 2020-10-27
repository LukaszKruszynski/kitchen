package com.kitchen.service;

import com.kitchen.domain.Fridge;
import com.kitchen.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeService {
    @Autowired
    FridgeRepository repository;

    public Fridge saveFridge(final Fridge fridge) {
        return repository.save(fridge);
    }

    public void deleteFridge(final Fridge fridge) {
        repository.delete(fridge);
    }
}
