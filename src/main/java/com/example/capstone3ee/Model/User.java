package com.example.capstone3ee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username cannot be null or empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
  //  @Column(nullable = false, unique = true, length = 20)
    private String username;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be a valid email address")
 //   @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "Password cannot be null or empty")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    @Column(columnDefinition = "varchar(30) not null ")
    private String password;

    @Size(max = 250, message = "Bio cannot exceed 250 characters")
    @Column(columnDefinition = "varchar(250) not null ")
    private String bio;

    @Size(max = 100, message = "Interests cannot exceed 100 characters")
    @Column(columnDefinition = "varchar(100) not null ")
    private String interests;

    @Size(max = 100, message = "Career goals cannot exceed 100 characters")
    @Column(columnDefinition = "varchar(100) not null ")
    private String careerGoals;

    @Column(columnDefinition = "int ")
    private int evaluationResult;

    @NotEmpty(message = "Role cannot be null or empty")
  //  @Column(nullable = false, length = 20)
    @Pattern(regexp = "^(admin|user)$", message = "Role must be 'admin' or 'user'")
    private String role;




}
