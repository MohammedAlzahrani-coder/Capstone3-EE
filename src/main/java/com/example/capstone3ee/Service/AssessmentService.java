package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.Assessment;
import com.example.capstone3ee.Repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class AssessmentService {
    private final AssessmentRepository assessmentRepository;

    public List<Assessment> getAllAssessments() {
       return  assessmentRepository.findAll();
    }

    public void addAssessment(Assessment assessment) {
        assessmentRepository.save(assessment);
    }


    public void updateAssessment(Integer assessmentId, Assessment assessment) {
        Assessment assessment1 = assessmentRepository.findAssessmentById(assessmentId);
        if (assessment1 == null) {
            throw new ApiException("Assessment not found");
        }
        assessment1.setAssessmentType(assessment.getAssessmentType());
        assessment1.setScore(assessment.getScore());
        assessment1.setAnswer(assessment.getAnswer());
        assessment1.setQuestions(assessment.getQuestions());
        assessment1.setDateTaken(assessment.getDateTaken());
        assessment1.setStatus(assessment.getStatus());
        assessmentRepository.save(assessment1);
    }
    public void deleteAssessment(Integer id) {
        Assessment assessment=assessmentRepository.findAssessmentById(id);
        if(assessment==null) {
            throw new ApiException("assessment not found");
        }
        assessmentRepository.delete(assessment);
    }




}
