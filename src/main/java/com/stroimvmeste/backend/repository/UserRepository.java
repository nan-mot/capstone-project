package com.stroimvmeste.backend.repository;

import com.stroimvmeste.backend.model.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);
    void deleteById(Long id);

    Optional<User> findById(Long id);

    Iterable<User> findAll();

    Optional<User> findByUserName(String userName);

}
