package com.example.capstone3ee.Controller;


import com.example.capstone3ee.Model.Assessment;
import com.example.capstone3ee.Service.AssessmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/assessment")
public class AssessmentController {
    private final AssessmentService assessmentService;

    @GetMapping("/get")
    public ResponseEntity getAssessment() {
        return ResponseEntity.status(200).body(assessmentService.getAllAssessments());
    }

    @PostMapping("/add")
    public ResponseEntity addAssement(@Valid @RequestBody Assessment assessment) {
        assessmentService.addAssessment(assessment);
        return ResponseEntity.status(200).body("assessment added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @Valid @RequestBody Assessment assessment) {
        assessmentService.updateAssessment(id, assessment);
        return ResponseEntity.status(200).body("assessment updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAssement(@PathVariable int id) {
        assessmentService.deleteAssessment(id);
        return ResponseEntity.status(200).body("assessment deleted successfully");
    }

//    @PutMapping("/{assementtId}/assign/{userId}")
//    public ResponseEntity assignAssement(@PathVariable int assementtId,  @PathVariable Integer userId) {
//        assessmentService.a(assementtId, userId);
//        return ResponseEntity.status(200).body("assessment assigned successfully");
//    }


}
