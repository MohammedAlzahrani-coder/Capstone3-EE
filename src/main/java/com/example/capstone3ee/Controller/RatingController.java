// src/main/java/com/example/capstone3ee/Controller/RatingController.java
package com.example.capstone3ee.Controller;

import com.example.capstone3ee.Model.Rating;
import com.example.capstone3ee.Service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    // GET all ratings
    @GetMapping("/get")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    // ADD a new rating
    @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    // UPDATE an existing rating
    @PutMapping("/update/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Integer id, @RequestBody Rating updatedRating) {
        Rating rating = ratingService.updateRating(id, updatedRating);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    // DELETE a rating
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Integer id) {
        ratingService.deleteRating(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}