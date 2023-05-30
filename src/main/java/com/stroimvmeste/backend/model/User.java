package com.stroimvmeste.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String fullName;

    private String userName;

    private Specialization specialization;

    private Double experience;

    private List<Initiative> participantInitiatives = new ArrayList<>();

}
