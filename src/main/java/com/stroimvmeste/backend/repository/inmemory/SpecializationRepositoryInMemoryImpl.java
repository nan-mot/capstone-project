package com.stroimvmeste.backend.repository.inmemory;

import com.stroimvmeste.backend.model.Specialization;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemory")
public class SpecializationRepositoryInMemoryImpl implements SpecializationRepository {

    private final Map<Long, Specialization> storage = new HashMap<>();
    @Override
    public Specialization save(Specialization specialization) {
        return storage.put(specialization.getId(), specialization);
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public Optional<Specialization> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Iterable<Specialization> findAll() {
        return storage.values();
    }
}
