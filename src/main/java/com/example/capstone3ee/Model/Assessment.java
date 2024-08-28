package com.example.capstone3ee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Entity
public class Assessment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentId;
   // private Integer userId;
    private String assessmentType;
    private int score;
    @ElementCollection
    private List<String> questions;
    @ElementCollection
    private List<String> answer;
    private Date dateTaken;
    private String status;


  // -------------------------- Relations ----------------------------
    @ManyToOne
    @JsonIgnore
    private User user; // 1 user many assessment

}
