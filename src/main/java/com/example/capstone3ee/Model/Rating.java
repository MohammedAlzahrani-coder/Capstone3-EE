package com.example.capstone3ee.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rating_id;

    @NotNull(message = "Request ID cannot be null")
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @NotNull(message = "Expert ID cannot be null")
    @ManyToOne
    @JoinColumn(name = "expert_id", nullable = false)
    private Expert expert;

    @NotEmpty(message = "Comment cannot be null or empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String comment;

    @NotNull(message = "Rating cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer add_rating;

    @NotNull(message = "Rating cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer get_rating;
}