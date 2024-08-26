package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.Resume;
import com.example.capstone3ee.Model.User;
import com.example.capstone3ee.Repository.ResumeRepository;
import com.example.capstone3ee.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    // GET all resumes
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    // ADD a new resume
    public void addResume(Integer userId, Resume resume) {
        User user = userRepository.findUserById(userId);
        if (user == null){
            new ApiException("User not found");
        }
        resume.setUserId(userId);
        resumeRepository.save(resume);
    }

    // UPDATE an existing resume
    public Resume updateResume(Integer id, Resume updatedResume) {
        Resume resume = resumeRepository.findResumeById(id);
        if (resume == null){
            new ApiException("User not found");
        }
        resume.setUserId(updatedResume.getUserId());
        resume.setContent(updatedResume.getContent());
        resume.setSkills(updatedResume.getSkills());
        resume.setProjects(updatedResume.getProjects());
        resume.setCertification(updatedResume.getCertification());
        resume.setAward(updatedResume.getAward());
        resume.setEducation(updatedResume.getEducation());
        return resumeRepository.save(resume);
    }

    // DELETE a resume
    public void deleteResume(Integer id) {
        Resume resume = resumeRepository.findResumeById(id);
        if (resume == null) {
            throw new ApiException("Resume not found");
        }
        resumeRepository.delete(resume);
    }


}