package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.dto.UserDistrictTitleDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.DistrictRepository;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import com.stroimvmeste.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InitiativeService {

    private final InitiativeRepository initiativeRepository;
    private final UserRepository userRepository;
    private final SpecializationRepository specializationRepository;

    private final DistrictRepository districtRepository;

    public List<InitiativeLiteDto> getAllInitiatives() {
        List<InitiativeLiteDto> initiativeLiteDtos = new ArrayList<>();
        for (Initiative initiative : initiativeRepository.findAll()) {
            initiativeLiteDtos.add(mapInitiativeToLiteDto(initiative));
        }
        return initiativeLiteDtos;
    }

    public Optional<InitiativeFullDto> getInitiative(String title) {
        Optional<Initiative> initiativeOptional = initiativeRepository.findByTitle(title);
        if (initiativeOptional.isPresent()) {
            Initiative initiative = initiativeOptional.get();
            return Optional.of(new InitiativeFullDto(initiative.getId(), initiative.getTitle(),
                    initiative.getDescription(), getParticipantsLiteDto(title),
                    initiative.getSpecialization().getName(), initiative.getDistrict().getTitle()));
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
                .setSpecialization(initiative.getSpecialization().getName())
                .setDistrict(initiative.getDistrict().getTitle());
    }

    public Initiative mapLiteDtoToInitiative(InitiativeLiteDto initiativeLiteDto) {
        return new Initiative()
                .setTitle(initiativeLiteDto.getTitle())
                .setDescription(initiativeLiteDto.getDescription())
                .setSpecialization(specializationRepository.findByName(initiativeLiteDto.getSpecialization()))
                .setDistrict(districtRepository.findByTitle(initiativeLiteDto.getDistrict()).orElse(null));
    }

    public void deleteInitiative(Long id) {
        initiativeRepository.deleteById(id);
    }

    public void addParticipant(String initiativeTitle, String userName) {
        Optional<Initiative> optionalInitiative = initiativeRepository.findByTitle(initiativeTitle);
        if (optionalInitiative.isPresent()) {
            Initiative initiative = optionalInitiative.get();
            Optional<User> optionalUser = userRepository.findByUserName(userName);
            optionalUser.ifPresent(user -> initiative.getParticipants().add(user));
        }
    }

    public List<UserDistrictTitleDto> getParticipantsLiteDto(String title) {
        Optional<Initiative> optionalInitiative = initiativeRepository.findByTitle(title);
        List<UserDistrictTitleDto> userLiteDtos = new ArrayList<>();
        if (optionalInitiative.isPresent()) {
            Initiative initiative = optionalInitiative.get();
            for (User user : initiative.getParticipants()) {
                userLiteDtos.add(new UserDistrictTitleDto(user.getId(),
                        user.getFullName(), user.getUserName(), user.getDistrict().getTitle()));
            }
        }
        return userLiteDtos;
    }

    public List<ExpertDto> generateListOfExperts(String title) {
        Initiative initiative = initiativeRepository.findByTitle(title).get();
        long specializationId = initiative.getSpecialization().getId();
        List<User> participants = initiative.getParticipants();
        List<User> experts = new ArrayList<>();
        for (User participant : participants) {
            if (participant.getSpecialization() != null) {
                if (participant.getSpecialization().getId() == specializationId) {
                    experts.add(participant);
                }
            }
        }
        experts.sort(Comparator.comparingDouble(User::getExperience).reversed());
        List<ExpertDto> expertsDto = new ArrayList<>();
        for (User participant : experts) {
            expertsDto.add(new ExpertDto(participant.getId(),
                    participant.getFullName(), participant.getUserName(),
                    participant.getSpecialization().getName(), participant.getDistrict().getTitle(), participant.getExperience()));
        }
        return expertsDto;
    }


}
