package com.stroimvmeste.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {
//    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

//    @Column(name = "specialization_name")
    private String name;

//    @OneToMany(mappedBy = "specialization",
//            orphanRemoval = true,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
    private List<Initiative> specializationInitiatives = new ArrayList<>();

//    @OneToMany(mappedBy = "specialization",
//            orphanRemoval = true,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
    private List<User> specializationUsers = new ArrayList<>();
}
