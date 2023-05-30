package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.SpecializationDto;
import com.stroimvmeste.backend.controller.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specializations")
@RequiredArgsConstructor
public class SpecializationController {
    private final SpecializationService specializationService;

    @PostMapping("/create")
    public SpecializationDto createSpecialization(@RequestBody SpecializationDto specializationDto) {
        return specializationService.addSpecialization(specializationDto);
    }

    @GetMapping("/all")
    public List<SpecializationDto> viewAllSpecializations() {
        return specializationService.getAllSpecializations();
    }

    @GetMapping("/{id}")
    public SpecializationDto viewSpecialization(@PathVariable Long id) {
        return specializationService.getSpecialization(id).get();
    }
}
