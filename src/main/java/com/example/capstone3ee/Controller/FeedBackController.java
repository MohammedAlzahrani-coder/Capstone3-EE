package com.example.capstone3ee.Controller;

import com.example.capstone3ee.DTO.FeedBackDTO;
import com.example.capstone3ee.Model.FeedBack;

import com.example.capstone3ee.Service.FeedBackService;
import jakarta.validation.Valid;
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
    public ResponseEntity createFeedbackToRequest(@Valid @RequestBody FeedBackDTO feedBackDTO) {
        feedbackService.addFeedback(feedBackDTO);
        return ResponseEntity.status(200).body("Feedback Added To Request Successfully");
    }

    @PutMapping("/update")
    public ResponseEntity updateFeedback( @Valid @RequestBody FeedBackDTO feedBackDTO) {
       feedbackService.updateFeedback(feedBackDTO);
        return ResponseEntity.status(200).body(" FeedBack's Request Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFeedback(@PathVariable Integer id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.status(200).body("feedback deleted");
    }


    @GetMapping("/{requestId}/feedback")// get feedBack for request
    public ResponseEntity<String> getAssessmentFeedback(@PathVariable Integer requestId) {
        String feedback = feedbackService.getFeedbackForRequest(requestId);

        if(feedback != null) {
            return ResponseEntity.ok(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}