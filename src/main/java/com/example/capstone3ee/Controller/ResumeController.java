package com.example.capstone3ee.Controller;

import com.example.capstone3ee.Model.Resume;
import com.example.capstone3ee.Service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    // GET all resumes
    @GetMapping("/get")
    public ResponseEntity getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return  ResponseEntity.status(200).body(resumes);
    }

    // ADD a new resume
    @PostMapping("/add")
    public ResponseEntity addResume(@RequestParam Integer userId, @Validated @RequestBody Resume resume) {
        resumeService.addResume(userId, resume);
        return ResponseEntity.status(201).body("resume added successfully");
    }

    // UPDATE an existing resume
    @PutMapping("/update/{id}")
    public ResponseEntity updateResume(@PathVariable Integer id, @Validated @RequestBody Resume updatedResume) {
        Resume resume = resumeService.updateResume(id, updatedResume);
        return ResponseEntity.status(201).body("resume updated successfully");
    }

    // DELETE a resume
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResume(@PathVariable Integer id) {
        resumeService.deleteResume(id);
        return ResponseEntity.status(201).body("resume deleted successfully");
    }

}