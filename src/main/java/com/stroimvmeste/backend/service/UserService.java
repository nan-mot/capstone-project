package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.model.District;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.DistrictRepository;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import com.stroimvmeste.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SpecializationRepository specializationRepository;

    private final DistrictRepository districtRepository;

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
                .setUserName(user.getUserName())
                .setDistrict(user.getDistrict().getTitle());
    }


    public User mapLiteDtoToUser(UserLiteDto userLiteDto) {
        return new User()
                .setFullName(userLiteDto.getFullName())
                .setUserName(userLiteDto.getUserName())
                .setDistrict(districtRepository.findByTitle(userLiteDto.getDistrict()).orElse(null));
    }


    public User mapExpertDtoToUser(ExpertDto expertDto) {
        return new User()
                .setFullName(expertDto.getFullName())
                .setUserName(expertDto.getUserName())
                .setExperience(expertDto.getExperience())
                .setSpecialization(specializationRepository.findByName(expertDto.getSpecialization()))
                .setDistrict(districtRepository.findByTitle(expertDto.getDistrict()).orElse(null));
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
        for (User user : userRepository.findAll()) {
            userLiteDtos.add(mapUserToLiteDto(user));
        }
        return userLiteDtos;
    }
}
