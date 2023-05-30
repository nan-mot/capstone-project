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
public class ExpertDto {
    private long id;

    private String fullName;

    private String userName;

    private Long specialization;

    private Double experience;
}
