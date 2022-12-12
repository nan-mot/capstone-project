package com.stroimvmeste.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "specialization_name")
    private String name;

    @OneToMany(mappedBy = "specialization",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Initiative> specializationInitiatives = new ArrayList<>();

    @OneToMany(mappedBy = "specialization",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<User> specializationUsers = new ArrayList<>();
}
