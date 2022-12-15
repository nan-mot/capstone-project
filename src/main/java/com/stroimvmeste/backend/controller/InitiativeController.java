package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.service.InitiativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/initiatives")
@RequiredArgsConstructor
public class InitiativeController {

    private final InitiativeService initiativeService;

    @PostMapping("/create")
    public InitiativeLiteDto createInitiative(@RequestBody InitiativeLiteDto initiativeLiteDto) {
        return initiativeService.addInitiative(initiativeLiteDto);
    }

    @GetMapping("/all")
    public List<InitiativeLiteDto> viewAllInitiatives() {
        return initiativeService.getAllInitiatives();
    }

    @GetMapping("/{id}")
    public InitiativeFullDto viewInitiative(@PathVariable Long id) {
        return initiativeService.getInitiative(id).get();
    }

    @PostMapping("/{initiativeId}/participate/{userId}")
    public void addParticipant(@PathVariable Long initiativeId,@PathVariable Long userId) {
        initiativeService.addParticipant(initiativeId,userId);
    }

    @GetMapping("/{id}/experts")
    public List<ExpertDto> generateListOfExperts(@PathVariable Long id) {

        return initiativeService.generateListOfExperts(id);
    }
}
