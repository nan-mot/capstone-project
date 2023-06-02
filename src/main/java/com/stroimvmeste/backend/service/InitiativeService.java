package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.InitiativeByIdDto;
import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.dto.UserDistrictTitleDto;
import com.stroimvmeste.backend.model.District;
import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.Specialization;
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

    public Optional<InitiativeFullDto> getInitiative(Long id) {
        Optional<Initiative> initiativeOptional = initiativeRepository.findById(id);
        if (initiativeOptional.isPresent()) {
            Initiative initiative = initiativeOptional.get();
            return Optional.of(new InitiativeFullDto(initiative.getId(), initiative.getTitle(),
                    initiative.getDescription(), getParticipantsLiteDto(initiative.getTitle()),
                    initiative.getSpecialization().getName(), initiative.getDistrict().getTitle()));
        } else {
            return Optional.empty();
        }
    }


    public InitiativeByIdDto addInitiative(InitiativeByIdDto initiativeLiteDto) {
        initiativeRepository.save(mapLiteDtoToInitiative(initiativeLiteDto));
        return initiativeLiteDto;
    }

    public InitiativeByIdDto updateInitiative(InitiativeByIdDto initiativeLiteDto) {
        Optional<Initiative> initiativeOptional = initiativeRepository.findById(initiativeLiteDto.getId());
        District district = districtRepository.findById(initiativeLiteDto.getDistrictId()).orElse(null);
        Specialization specialization = specializationRepository.findById(initiativeLiteDto.getSpecializationId()).orElse(null);
        if (initiativeOptional.isPresent()) {
            initiativeOptional.get().setTitle(initiativeLiteDto.getTitle())
                    .setDescription(initiativeLiteDto.getDescription())
                    .setDistrict(district)
                    .setSpecialization(specialization);
            initiativeRepository.save(initiativeOptional.get());
        }
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

    public Initiative mapLiteDtoToInitiative(InitiativeByIdDto initiativeLiteDto) {
        District district = districtRepository.findById(initiativeLiteDto.getDistrictId()).orElse(null);
        Specialization specialization = specializationRepository.findById(initiativeLiteDto.getSpecializationId()).orElse(null);
        return new Initiative()
                .setTitle(initiativeLiteDto.getTitle())
                .setDescription(initiativeLiteDto.getDescription())
                .setSpecialization(specialization)
                .setDistrict(district);
    }

    public void deleteInitiative(Long id) {
        initiativeRepository.deleteById(id);
    }

    public void addParticipant(Long initiativeId, Long participantId) {
        Optional<Initiative> optionalInitiative = initiativeRepository.findById(initiativeId);
        if (optionalInitiative.isPresent()) {
            Initiative initiative = optionalInitiative.get();
            Optional<User> optionalUser = userRepository.findById(participantId);
            if (optionalUser.isPresent() & !initiative.getParticipants().contains(optionalUser.get())) {
                optionalUser.ifPresent(user -> initiative.getParticipants().add(user));
                initiativeRepository.save(initiative);
            }
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

    public List<ExpertDto> generateListOfExperts(Long id) {
        Initiative initiative = initiativeRepository.findById(id).get();
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
