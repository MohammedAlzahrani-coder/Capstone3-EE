package com.example.capstone3ee.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Expert {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expertId;

//    @NotNull(message = "User ID cannot be null")
//   // @Column(columnDefinition = "varchar(8) unique not null")
//    private Integer userId;


    @NotEmpty(message = "Full Name  cannot be null or empty")
    @Column(columnDefinition = "varchar(65)  not null ")
    private String fullName;

    private String gender;
    //@Column(columnDefinition = "int not null check(age>=23)")
    private  int age;

    @NotNull(message = "Years of Experience..? ")
    @Column(columnDefinition = "int not null")
    private int yearsOfExperience;

    @NotEmpty(message = "Expertise cannot be null or empty")
    @Column(columnDefinition = "varchar(65)  not null ")
    private String expertise;

    @NotEmpty(message = "Major cannot be null or empty")
    @Column(columnDefinition = "varchar(20)  not null ")
    private String major;

    @NotEmpty(message = "Qualifications cannot be null or empty")
    @Column(columnDefinition = "varchar(35)  not null ")
    private String qualificationDegree;

    @NotEmpty(message = "Experience cannot be null or empty")
    @Column(columnDefinition = "varchar(50)  not null ")
    private String experience;

    @ElementCollection
    @NotEmpty(message = "skills of expert is require ")
    private List<String> skills;

    private Integer ratings;

    @NotEmpty(message = "Availability cannot be null or empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String availability;

//    @ElementCollection
//    @NotEmpty(message = "Expertise list cannot be null or empty")
//   // @Column(columnDefinition = "varchar(20) not null")
//    private List<String> expertiseList;

    @NotEmpty(message = "Status cannot be null or empty")
    @Column(columnDefinition = "varchar(10) not null ")
    private String status;

// -------------------------------------------- Relations -----------------------------

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expert") // one expert have many requests
    private Set<Request> requests ;

}
