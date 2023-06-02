package com.stroimvmeste.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Specialization {
    @Id
    @Column(name = "specialization_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",
            unique = true)
    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Initiative> initiatives = new ArrayList<>();

    @OneToMany(mappedBy = "specialization")
    private List<User> users = new ArrayList<>();
}
