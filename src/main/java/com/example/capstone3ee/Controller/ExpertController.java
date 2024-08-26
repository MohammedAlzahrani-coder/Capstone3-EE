package com.example.capstone3ee.Controller;


import com.example.capstone3ee.Model.Expert;
import com.example.capstone3ee.Service.ExpertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/expert")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    @GetMapping("/get")
    public ResponseEntity getAllExperts() {
        return ResponseEntity.status(200).body(expertService.getAllExperts());
    }

    @PostMapping("/add")
    public ResponseEntity addExpert(@Valid @RequestBody Expert expert) {
        expertService.addExpert(expert);
        return ResponseEntity.status(200).body("Expert added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateExpert(@Valid @RequestBody Expert expert, @PathVariable Integer id) {
        expertService.updateExpert(id, expert);
        return ResponseEntity.status(200).body("Expert updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteExpert(@PathVariable Integer id) {
        expertService.deleteExpert(id);
        return ResponseEntity.status(200).body("Expert deleted successfully");
    }
}