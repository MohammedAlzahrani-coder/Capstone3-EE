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
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }

    // ADD a new resume
    @PostMapping("/add")
    public ResponseEntity<Resume> addResume(@RequestParam Integer userId, @Validated @RequestBody Resume resume) {
        resumeService.addResume(userId, resume);
        return new ResponseEntity<>(resume, HttpStatus.CREATED);
    }

    // UPDATE an existing resume
    @PutMapping("/update/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Integer id, @Validated @RequestBody Resume updatedResume) {
        Resume resume = resumeService.updateResume(id, updatedResume);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    // DELETE a resume
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Integer id) {
        resumeService.deleteResume(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}