package com.stroimvmeste.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private List<Initiative> specializationInitiatives = new ArrayList<>();

    private List<User> specializationUsers = new ArrayList<>();
}
