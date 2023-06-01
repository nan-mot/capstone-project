package com.stroimvmeste.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class InitiativeFullDto {
    private Long id;

    private String title;

    private String description;

    private List<UserDistrictTitleDto> participants;

    private String specialization;

    private String district;

}
