package com.example.capstone3ee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    private String taskName;
    private LocalDate dueDate;
    private String details;
    private int teamPerformanceRating;



    // --------------------------------- relations --------------------------
    @ManyToMany
    @JsonIgnore
    private Set<Groups> groups;

}
