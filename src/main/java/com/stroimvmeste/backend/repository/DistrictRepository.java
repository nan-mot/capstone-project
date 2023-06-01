package com.stroimvmeste.backend.repository;

import com.stroimvmeste.backend.model.District;

import java.util.Optional;

public interface DistrictRepository {

    District save(District district);

    void deleteById(Long id);

    Optional<District> findById(Long id);

    Iterable<District> findAll();

    Optional<District> findByTitle(String title);
}
