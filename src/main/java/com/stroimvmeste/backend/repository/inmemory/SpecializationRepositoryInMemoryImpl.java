package com.stroimvmeste.backend.repository.inmemory;

import com.stroimvmeste.backend.model.Specialization;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("inmemory")
public class SpecializationRepositoryInMemoryImpl extends AbstractInMemory<Specialization> implements SpecializationRepository {


    public SpecializationRepositoryInMemoryImpl() {
        super(SpecializationRepositoryInMemoryImpl.class.getSimpleName(), Specialization.class);
    }

    @Override
    public Specialization findByName(String name) {
        return null;
    }
}
