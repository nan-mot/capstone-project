package com.stroimvmeste.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Initiative {
    @Id
    @Column(name = "initiative_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title",
            unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "specializationId", insertable = false, updatable = false)
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "districtId", insertable = false, updatable = false)
    private District district;

    @ManyToMany
    @JoinTable(name = "initiative_user",
            joinColumns = @JoinColumn(name = "initiative_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> participants = new ArrayList<>();
}

