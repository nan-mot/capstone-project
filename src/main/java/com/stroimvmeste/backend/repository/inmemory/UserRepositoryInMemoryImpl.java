package com.stroimvmeste.backend.repository.inmemory;


import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemory")
public class UserRepositoryInMemoryImpl implements UserRepository {

    private final Map<Long, User> storage = new HashMap<>();

    @Override
    public User save(User user) {
        return storage.put(user.getId(), user);
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Iterable<User> findAll() {
        return storage.values();
    }
}
