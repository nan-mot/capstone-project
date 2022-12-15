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
public class User {
//    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

//    @Column(name = "user_fullName")
    private String fullName;

//    @Column(name = "user_fullName")
    private String userName;

//    @ManyToOne
//    @JoinColumn(name = "id", insertable = true, updatable = true)
//    @Column(name = "specialization")
    private Specialization specialization;

//    @Column(name = "experience")
    private Double experience;

    private List<Initiative> participantInitiatives = new ArrayList<>();

}
