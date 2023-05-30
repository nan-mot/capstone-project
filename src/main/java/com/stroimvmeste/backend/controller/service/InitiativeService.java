package com.stroimvmeste.backend.controller.service;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import com.stroimvmeste.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class InitiativeService {

    public final InitiativeRepository initiativeRepository;
    public final UserRepository userRepository;
    public final SpecializationRepository specializationRepository;

    public List<InitiativeLiteDto> getAllInitiatives() {
        List<InitiativeLiteDto> initiativeLiteDtos = new ArrayList<>();
        for (Initiative initiative : initiativeRepository.findAll()) {
            initiativeLiteDtos.add(mapInitiativeToLiteDto(initiative));
        }
        return initiativeLiteDtos;
    }

    public Optional<InitiativeFullDto> getInitiative(Long id) {
        Optional<Initiative> initiativeOptional = initiativeRepository.findById(id);
        if (initiativeOptional.isPresent()) {
            Initiative initiative = initiativeOptional.get();
            return Optional.of(new InitiativeFullDto(initiative.getId(), initiative.getTitle(),
                    initiative.getDescription(), getParticipantsLiteDto(id), initiative.getSpecialization().getId()));
        } else {
            return Optional.empty();
        }
    }


    public InitiativeLiteDto addInitiative(InitiativeLiteDto initiativeLiteDto) {
        initiativeRepository.save(mapLiteDtoToInitiative(initiativeLiteDto));
        return initiativeLiteDto;
    }

    public InitiativeLiteDto mapInitiativeToLiteDto(Initiative initiative) {
        return new InitiativeLiteDto()
                .setId(initiative.getId())
                .setTitle(initiative.getTitle())
                .setDescription(initiative.getDescription())
                .setSpecialization(initiative.getSpecialization().getId());
    }

    public Initiative mapLiteDtoToInitiative(InitiativeLiteDto initiativeLiteDto) {
        return new Initiative()
                .setId(initiativeLiteDto.getId())
                .setTitle(initiativeLiteDto.getTitle())
                .setDescription(initiativeLiteDto.getDescription())
                .setSpecialization(specializationRepository.findById(initiativeLiteDto.getSpecialization()).get());
    }

    public void deleteInitiative(Long id) {
        initiativeRepository.deleteById(id);
    }

    public void addParticipant(Long initiativeId, Long userId) {
        Optional<Initiative> optionalInitiative = initiativeRepository.findById(initiativeId);
        if (optionalInitiative.isPresent()) {
            Initiative initiative = optionalInitiative.get();
            Optional<User> optionalUser = userRepository.findById(userId);
            optionalUser.ifPresent(user -> initiative.getParticipants().add(user));
        }
    }
    public List<UserLiteDto> getParticipantsLiteDto(Long id){
        Optional<Initiative> optionalInitiative = initiativeRepository.findById(id);
        List<UserLiteDto> userLiteDtos = new ArrayList<>();
        if (optionalInitiative.isPresent()) {
            Initiative initiative = optionalInitiative.get();
            for (User user : initiative.getParticipants()) {
                userLiteDtos.add(new UserLiteDto(user.getId(), user.getFullName(), user.getUserName()));
            }
        } return userLiteDtos;
    }

    public List<ExpertDto> generateListOfExperts(Long id) {
        Initiative initiative = initiativeRepository.findById(id).get();
        Long specializationId = initiative.getSpecialization().getId();
        List<User> participants = initiative.getParticipants();
        List<User> experts = new ArrayList<>();
        for (User participant : participants) {
            if (participant.getSpecialization() != null) {
                if (participant.getSpecialization().getId() == specializationId) {
                    experts.add(participant);
            } else continue;
            } else continue;
        }
        experts.sort(Comparator.comparingDouble(User::getExperience).reversed());
        List<ExpertDto> expertsDto = new ArrayList<>();
        for (User participant : experts) {
            expertsDto.add(new ExpertDto(participant.getId(),
                    participant.getFullName(), participant.getUserName(),
                    participant.getSpecialization().getId(), participant.getExperience()));
        }
        return expertsDto;
    }


}
