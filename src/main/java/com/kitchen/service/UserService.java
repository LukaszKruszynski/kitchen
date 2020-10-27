package com.kitchen.service;

import com.kitchen.domain.User;
import com.kitchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public void deleteUser(final User user) {
         repository.delete(user);
    }
    public Optional<User> getUser(final Long id) {
        return repository.findById(id);
    }
    public List<User> getUsers() {
        return repository.findAll();
    }
}
