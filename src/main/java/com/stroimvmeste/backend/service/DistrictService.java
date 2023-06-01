package com.stroimvmeste.backend.service;

import com.stroimvmeste.backend.dto.DistrictDto;
import com.stroimvmeste.backend.model.District;
import com.stroimvmeste.backend.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictDto addDistrict(DistrictDto districtDto) {
        districtRepository.save(mapDtoToDistrict(districtDto));
        return districtDto;
    }

    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }

    public List<DistrictDto> getAllDistricts() {
        List<DistrictDto> districtDtos = new ArrayList<>();
        for (District district : districtRepository.findAll()) {
            districtDtos.add(mapDistrictToDto(district));
        }
        return districtDtos;
    }

    public DistrictDto mapDistrictToDto(District district) {
        return new DistrictDto()
                .setId(district.getId())
                .setTitle(district.getTitle());
    }

    public District mapDtoToDistrict(DistrictDto districtDto) {
        return new District()
                .setTitle(districtDto.getTitle());
    }

}
