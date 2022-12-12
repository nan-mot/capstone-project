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
public class Initiative {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "initiative_title")
    private String title;

    @Column(name = "initiative_description")
    private String description;


    @Column(name = "participants")
    private List<User> participants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id", insertable = true, updatable = true)
    @Column(name = "specialization")
    private Specialization specialization;

}

