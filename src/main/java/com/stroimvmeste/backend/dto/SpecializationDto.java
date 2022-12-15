package com.stroimvmeste.backend.dto;


import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDto {
    private long id;
    private String name;
}
