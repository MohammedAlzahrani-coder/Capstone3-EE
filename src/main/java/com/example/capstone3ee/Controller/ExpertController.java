package com.example.capstone3ee.Controller;


import com.example.capstone3ee.Model.Expert;
import com.example.capstone3ee.Service.ExpertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  // ------------------------------------------------- end point --------------------------------
  @GetMapping("/search/{skills}")
  public ResponseEntity<List<Expert> >searchExpertsBySkills(@PathVariable String skills) {
      return ResponseEntity.status(200).body(expertService.findExpertsBySkills(skills));
  }



//    @GetMapping("/matchSkills")
//    public ResponseEntity<List<Expert>> matchUsersToExperts() {
//        return ResponseEntity.status(200).body(expertService.matchUsersToExperts());
//    }



    @GetMapping("/experts/{major}")
    public ResponseEntity<List<Expert>> getExpertsBySpecialty(@PathVariable String major) {
        return ResponseEntity.status(200).body(expertService.filterExpertsBySpecialty(major));
    }


}