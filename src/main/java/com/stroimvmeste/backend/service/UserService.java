package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.UserDistrictIdDto;
import com.stroimvmeste.backend.dto.UserDistrictTitleDto;
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

    public UserLiteDto addUser(UserDistrictIdDto userLiteDto) {
        userRepository.save(mapLiteDtoToUser(userLiteDto));
        return userLiteDto;
    }

    public ExpertDto addExpert(ExpertDto expertDto) {
        userRepository.save(mapExpertDtoToUser(expertDto));
        return expertDto;
    }

    public UserDistrictTitleDto mapUserToLiteDto(User user) {
        return new UserDistrictTitleDto(user.getId(),
                user.getFullName(),
                user.getUserName(),
                user.getDistrict().getTitle());
    }


    public User mapLiteDtoToUser(UserDistrictIdDto userLiteDto) {
        District district = districtRepository.findById(userLiteDto.getDistrictId()).orElse(null);
        return new User()
                .setFullName(userLiteDto.getFullName())
                .setUserName(userLiteDto.getUserName())
                .setDistrict(district);
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

    public Optional<UserDistrictTitleDto> getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.of(mapUserToLiteDto(user));
        } else {
            return Optional.empty();
        }
    }

    public List<UserDistrictTitleDto> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        List<UserDistrictTitleDto> userLiteDtos = new ArrayList<>();
        for (User user : allUsers) {
            userLiteDtos.add(mapUserToLiteDto(user));
        }
        return userLiteDtos;
    }
}
