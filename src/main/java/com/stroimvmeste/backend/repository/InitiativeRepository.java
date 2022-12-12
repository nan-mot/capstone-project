package com.stroimvmeste.backend.repository;

import com.stroimvmeste.backend.model.Initiative;

public interface InitiativeRepository {

    Initiative save(Initiative initiative);
    void deleteById(Long id);
}
