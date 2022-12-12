package com.stroimvmeste.backend.dto;

import com.stroimvmeste.backend.model.Specialization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiativeCreateDto {

    private long id;
    private String title;
    private String description;
    private Specialization specialization;

}
