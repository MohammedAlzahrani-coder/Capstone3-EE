package com.example.capstone3ee.Controller;

import com.example.capstone3ee.Model.Groups;
import com.example.capstone3ee.Service.GroupsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class GroupsController {
 private GroupsService groupsService;


        @GetMapping("/get")
        public ResponseEntity getAllGroup() {
            return ResponseEntity.status(200).body(groupsService.getAllGroup());
        }


        @PostMapping("/add")
        public ResponseEntity addGroup(@Valid @RequestBody Groups group) {
            groupsService.addGroup(group);
            return ResponseEntity.status(200).body("group added successfully");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateGroup(@PathVariable int id, @Valid @RequestBody Groups group) {
            groupsService.updateGroup(id, group);
            return ResponseEntity.status(200).body("group updated successfully");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteGroup(@PathVariable int id) {
            groupsService.deleteGroup(id);
            return ResponseEntity.status(200).body("group deleted successfully");
        }


    

}
