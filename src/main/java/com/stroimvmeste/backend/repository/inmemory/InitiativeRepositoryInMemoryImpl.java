package com.stroimvmeste.backend.repository.inmemory;

import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("inmemory")
public class InitiativeRepositoryInMemoryImpl extends AbstractInMemory<Initiative> implements InitiativeRepository {


    public InitiativeRepositoryInMemoryImpl() {
        super(InitiativeRepositoryInMemoryImpl.class.getSimpleName(), Initiative.class);
    }

    @Override
    public Optional<Initiative> findByTitle(String title) {
        return Optional.empty();
    }
}
