package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.SpecializationDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController {
    @PostMapping("/create")
    public SpecializationDto createSpecialization(@RequestBody SpecializationDto specializationDto) {

        return specializationDto;
    }
}
