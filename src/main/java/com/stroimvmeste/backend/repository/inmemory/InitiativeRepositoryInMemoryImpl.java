package com.stroimvmeste.backend.repository.inmemory;

import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Profile("inmemory")
public class InitiativeRepositoryInMemoryImpl implements InitiativeRepository {

    private final Map<Long, Initiative> storage = new HashMap<>();


    @Override
    public Initiative save(Initiative initiative) {
        return storage.put(initiative.getId(), initiative);
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public Optional<Initiative> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Iterable<Initiative> findAll() {
        return storage.values();
    }
}
