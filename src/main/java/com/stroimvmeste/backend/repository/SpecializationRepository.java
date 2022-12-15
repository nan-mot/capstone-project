package com.stroimvmeste.backend.repository;

import com.stroimvmeste.backend.model.Specialization;

import java.util.Optional;

public interface SpecializationRepository {
    Specialization save(Specialization specialization);
    void deleteById(Long id);
    Optional<Specialization> findById(Long id);

    Iterable<Specialization> findAll();
}
