package com.stroimvmeste.backend.repository.inmemory;

import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.Specialization;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemory")
public class SpecializationRepositoryInMemoryImpl extends AbstractInMemory<Specialization> implements SpecializationRepository {


    public SpecializationRepositoryInMemoryImpl() {
        super(SpecializationRepositoryInMemoryImpl.class.getSimpleName(), Specialization.class);
    }

    @Override
    public Specialization save(Specialization specialization) {
        return get(put(specialization.getId(), specialization));
    }
}
