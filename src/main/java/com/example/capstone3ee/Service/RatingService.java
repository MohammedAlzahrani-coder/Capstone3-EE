// src/main/java/com/example/capstone3ee/Service/RatingService.java
package com.example.capstone3ee.Service;

import com.example.capstone3ee.Model.Rating;
import com.example.capstone3ee.Repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    // GET
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // ADD
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    // UPDATE
    public Rating updateRating(Integer id, Rating updatedRating) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
        rating.setRequest(updatedRating.getRequest());
        rating.setExpert(updatedRating.getExpert());
        rating.setComment(updatedRating.getComment());
        rating.setAddRating(updatedRating.getAddRating());
        rating.setGetRating(updatedRating.getGetRating());

        return ratingRepository.save(rating);
    }

    // DELETE
    public void deleteRating(Integer id) {
        ratingRepository.deleteById(id);
    }
}