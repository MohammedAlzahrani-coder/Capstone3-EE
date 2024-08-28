package com.example.capstone3ee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @NotEmpty(message = "Name of group is required")
    @Column(columnDefinition = "varchar(30) unique  not null")
    private String name;

    @NotEmpty(message = "Name of group is required")
    @Column(columnDefinition = "varchar(30) unique  not null")
     private String groupType;

    @NotEmpty(message = "Description of group is required")
    @Column(columnDefinition = "varchar(70) not null")
    private String description;

    private int teamPerformance;
    @ElementCollection
    private List<String> members;

    @ElementCollection
    private List<String> projects;

    private boolean applicable;


    // ------------------------------ Relations -----------------
    @ManyToMany
    @JsonIgnore
    private Set<User> users;


    @ManyToMany(mappedBy ="groups")
    private Set<Events> events;

     @ManyToMany(mappedBy = "groups")
    private Set<Tasks> tasks;




}
