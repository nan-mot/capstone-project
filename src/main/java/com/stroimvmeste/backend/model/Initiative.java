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
public class Initiative {
//    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column(name = "initiative_title")
    private String title;

//    @Column(name = "initiative_description")
    private String description;


//    @Column(name = "participants")
    private List<User> participants = new ArrayList<>();

//    @Column(name = "experts")
    private List<User> experts = new ArrayList<>();


//    @ManyToOne
//    @JoinColumn(name = "id", insertable = true, updatable = true)
//    @Column(name = "specialization")
    private Specialization specialization;

}

