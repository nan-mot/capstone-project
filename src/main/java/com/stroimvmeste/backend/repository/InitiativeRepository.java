package com.stroimvmeste.backend.repository;

import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.model.Initiative;

import java.util.List;
import java.util.Optional;

public interface InitiativeRepository {

    Initiative save(Initiative initiative);

    void deleteById(Long id);

    Optional<Initiative> findById(Long id);

    Iterable<Initiative> findAll();


}
