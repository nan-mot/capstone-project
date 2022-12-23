package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.InitiativeFullDto;
import com.stroimvmeste.backend.dto.InitiativeLiteDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import com.stroimvmeste.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final SpecializationRepository specializationRepository;

    public UserLiteDto addUser(UserLiteDto userLiteDto) {
        userRepository.save(mapLiteDtoToUser(userLiteDto));
        return userLiteDto;
    }

    public ExpertDto addExpert(ExpertDto expertDto) {
        userRepository.save(mapExpertDtoToUser(expertDto));
        return expertDto;
    }

    public UserLiteDto mapUserToLiteDto(User user) {
        return new UserLiteDto()
                .setId(user.getId())
                .setFullName(user.getFullName())
                .setUserName(user.getUserName());
    }


    public User mapLiteDtoToUser(UserLiteDto userLiteDto) {
        return new User()
                .setId(userLiteDto.getId())
                .setFullName(userLiteDto.getFullName())
                .setUserName(userLiteDto.getUserName());
    }


    public User mapExpertDtoToUser(ExpertDto expertDto) {
        return new User()
                .setId(expertDto.getId())
                .setFullName(expertDto.getFullName())
                .setUserName(expertDto.getUserName())
                .setExperience(expertDto.getExperience())
                .setSpecialization(specializationRepository.findById(expertDto.getSpecialization()).get());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserLiteDto> getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.of(mapUserToLiteDto(user));
        } else {
            return Optional.empty();
        }
    }

    public List<UserLiteDto> getAllUsers() {
        List<UserLiteDto> userLiteDtos = new ArrayList<>();
        Object jhvjv = userRepository.findAll();
        for (User user : userRepository.findAll()) {
            userLiteDtos.add(mapUserToLiteDto(user));
        }
        return userLiteDtos;
    }
}
