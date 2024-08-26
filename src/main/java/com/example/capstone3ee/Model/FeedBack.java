package com.example.capstone3ee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "feedback_id")
    private Integer id;

    //@Column(name = "request_id")
    @NotNull(message = "Request ID cannot be null")
    private Integer requestId;

   // @Column(name = "feedback_text")
    //@NotBlank(message = "Feedback text cannot be empty")
    private String feedbackText;


}