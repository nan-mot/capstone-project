package com.stroimvmeste.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class InitiativeLiteDto {

    private Long id;

    private String title;

    private String description;

    private Long specialization;

}
