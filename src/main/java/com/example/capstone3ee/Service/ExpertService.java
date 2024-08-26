package com.example.capstone3ee.Service;


import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.Expert;
import com.example.capstone3ee.Repository.ExpertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertService {




    private final ExpertRepository expertRepository;

    public List<Expert> getAllExperts() {
        return expertRepository.findAll();
    }

    public void addExpert(Expert expert) {
        expertRepository.save(expert);
    }

    public void updateExpert(Integer id, Expert expert) {
        Expert updateExpert = expertRepository.findExpertById(id);

        if (updateExpert == null) {
            throw new ApiException("Expert not found");
        }

        updateExpert.setUserId(expert.getUserId());
        updateExpert.setExpertise(expert.getExpertise());
        updateExpert.setQualifications(expert.getQualifications());
        updateExpert.setExperience(expert.getExperience());
        updateExpert.setRatings(expert.getRatings());
        updateExpert.setAvailability(expert.getAvailability());
        updateExpert.setExpertiseList(expert.getExpertiseList());
        updateExpert.setStatus(expert.getStatus());

        expertRepository.save(updateExpert);
    }

    public void deleteExpert(Integer id) {
        Expert deleteExpert = expertRepository.findExpertById(id);

        if (deleteExpert == null) {
            throw new ApiException("Expert not found");
        }

        expertRepository.delete(deleteExpert);
    }
}


