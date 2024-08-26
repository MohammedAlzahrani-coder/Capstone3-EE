package com.example.capstone3ee.Service;

import com.example.capstone3ee.Model.FeedBack;
import com.example.capstone3ee.Repository.FeedBackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackService {

    private final FeedBackRepository feedbackRepository;

    // GET
    public List<FeedBack> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // ADD
    public void addFeedback(FeedBack feedback) {
         feedbackRepository.save(feedback);
    }

    // UPDATE
    public void updateFeedback(Integer id, FeedBack updatedFeedback) {
        FeedBack existingFeedback = feedbackRepository.findFeedBackById(id);
        if (existingFeedback == null) {
            throw new RuntimeException("Feedback not found");
        }
        existingFeedback.setRequestId(updatedFeedback.getRequestId());
        existingFeedback.setFeedbackText(updatedFeedback.getFeedbackText());
         feedbackRepository.save(existingFeedback);
    }

    // DELETE
    public void deleteFeedback(Integer id) {
        FeedBack feedback = feedbackRepository.findFeedBackById(id);
        if (feedback == null) {
            throw new RuntimeException("Feedback not found");
        }
        feedbackRepository.deleteById(id);
    }
}