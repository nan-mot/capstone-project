package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.SpecializationDto;
import com.stroimvmeste.backend.model.Specialization;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecializationService {

    public final SpecializationRepository specializationRepository;

    public SpecializationDto addSpecialization(SpecializationDto specializationDto) {
        specializationRepository.save(mapDtoToSpecialization(specializationDto));
        return specializationDto;
    }

    public void deleteSpecialization(Long id) {
        specializationRepository.deleteById(id);
    }


    public SpecializationDto mapSpecializationToDto(Specialization specialization) {
        return new SpecializationDto()
                .setId(specialization.getId())
                .setName(specialization.getName());
    }

    public Specialization mapDtoToSpecialization(SpecializationDto specializationDto) {
        return new Specialization()
                .setId(specializationDto.getId())
                .setName(specializationDto.getName());
    }

    public Optional<SpecializationDto> getSpecialization(Long id) {
        Optional<Specialization> specializationOptional = specializationRepository.findById(id);
        if (specializationOptional.isPresent()) {
            Specialization specialization = specializationOptional.get();
            return Optional.of(mapSpecializationToDto(specialization));
        } else {
            return Optional.empty();
        }
    }

    public List<SpecializationDto> getAllSpecializations() {
        List<SpecializationDto> specializationDtos = new ArrayList<>();
        for (Specialization specialization : specializationRepository.findAll()) {
            specializationDtos.add(mapSpecializationToDto(specialization));
        }
        return specializationDtos;
    }



}




