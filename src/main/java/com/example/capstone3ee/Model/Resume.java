package com.example.capstone3ee.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Resume {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotEmpty(message = "Content cannot be null or empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String content;

    @ElementCollection
    @NotEmpty(message = "Skills cannot be empty")
    private List<String> skills;

    @ElementCollection
    @NotEmpty(message = "Projects cannot be empty")
    private List<String> projects;

    @ElementCollection
    @NotEmpty(message = "Certifications cannot be empty")
    private List<String> certification;

    @ElementCollection
    @NotEmpty(message = "Awards cannot be empty")
    private List<String> award;

    @NotEmpty(message = "Education cannot be null or empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String education;

//    @OneToOne
//    @MapsId
//    @JsonIgnore
//    private User user;
//



}
