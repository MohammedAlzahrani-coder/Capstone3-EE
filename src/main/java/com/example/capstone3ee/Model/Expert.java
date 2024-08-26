package com.example.capstone3ee.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Expert {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID cannot be null")
   // @Column(columnDefinition = "varchar(8) unique not null")
    private Integer userId;

    @NotEmpty(message = "Expertise cannot be null or empty")
    @Column(columnDefinition = "varchar(65)  not null ")
    private String expertise;

    @NotEmpty(message = "Qualifications cannot be null or empty")
    @Column(columnDefinition = "varchar(35)  not null ")
    private String qualifications;

    @NotEmpty(message = "Experience cannot be null or empty")
    @Column(columnDefinition = "varchar(50)  not null ")
    private String experience;

    @NotNull(message = "Ratings cannot be null")
   // @Column(columnDefinition = "varchar(65) not null ")
    private Integer ratings;

    @NotEmpty(message = "Availability cannot be null or empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String availability;

    @ElementCollection
    @NotEmpty(message = "Expertise list cannot be null or empty")
   // @Column(columnDefinition = "varchar(20) not null")
    private List<String> expertiseList;

    @NotEmpty(message = "Status cannot be null or empty")
    @Column(columnDefinition = "varchar(10) not null ")
    private String status;



}
