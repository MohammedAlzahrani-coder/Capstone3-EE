package com.example.capstone3ee.Controller;

import com.example.capstone3ee.Model.FeedBack;

import com.example.capstone3ee.Service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
public class FeedBackController {

    private final FeedBackService feedbackService;

    @GetMapping("/get")
    public ResponseEntity getAllFeedbacks() {

        return ResponseEntity.status(200).body(feedbackService.getAllFeedback());
    }

    @PostMapping("/add")
    public ResponseEntity createFeedback(@Validated @RequestBody FeedBack feedback) {
        feedbackService.addFeedback(feedback);
        return ResponseEntity.status(200).body("Feedback Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFeedback(@PathVariable Integer id, @Validated @RequestBody FeedBack updatedFeedback) {
       feedbackService.updateFeedback(id, updatedFeedback);
        return ResponseEntity.status(200).body("FeedBack Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFeedback(@PathVariable Integer id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.status(200).body("feedback deleted");
    }
}