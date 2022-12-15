package com.stroimvmeste.backend.dto;

import com.stroimvmeste.backend.model.Specialization;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class InitiativeLiteDto {

    private long id;
    private String title;
    private String description;
    private Long specialization;

}
