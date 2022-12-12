package com.stroimvmeste.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "user_fullName")
    private String fullName;

    @Column(name = "user_fullName")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "id", insertable = true, updatable = true)
    @Column(name = "specialization")
    private Specialization specialization;

}
