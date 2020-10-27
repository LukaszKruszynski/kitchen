package com.kitchen.service;

import com.kitchen.domain.Freezer;
import com.kitchen.repository.FreezerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreezerService {
    @Autowired
    FreezerRepository repository;

    public Freezer saveFreezer(final Freezer freezer) {
        return repository.save(freezer);
    }

    public void deleteFreezer(final Freezer freezer) {
        repository.delete(freezer);
    }
}
