package com.stroimvmeste.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDistrictTitleDto {

    private long id;

    private String fullName;

    private String userName;

    private String district;
}
