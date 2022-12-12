package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiativeService {

    public final InitiativeRepository initiativeRepository;


    public Initiative addInitiative(Initiative initiative) {
        return initiativeRepository.save(initiative);
    }

    public void deleteInitiative(Long id) {
        initiativeRepository.deleteById(id);
    }

    public void addParticipant(User user) {

    }
}
