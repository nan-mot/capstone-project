package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.model.Specialization;
import com.stroimvmeste.backend.repository.crud.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationService {

    public final SpecializationRepository specializationRepository;

    public Specialization addSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public void deleteSpecialization(Integer id) {
        specializationRepository.deleteById(id);
    }
}
