package com.example.capstone3ee.Controller;

import com.example.capstone3ee.Model.Groups;
import com.example.capstone3ee.Service.GroupsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupsController {
 private final GroupsService groupsService;


        @GetMapping("/get")
        public ResponseEntity getAllGroups() {
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

     @PutMapping("/assign/{groupId}/{userId}")
    public ResponseEntity assignGroup(@PathVariable int groupId, @PathVariable int userId) {
            groupsService.assignUsersToGroups(groupId, userId);
            return ResponseEntity.status(200).body("group assigned successfully");
     }
 // ---------------------------- end point -------------------------------------------
    @DeleteMapping("/{groupId}/members/{userId}") // remove member from group
    public ResponseEntity<String> removeMemberFromGroup(@PathVariable Integer groupId, @PathVariable Integer userId) {
        groupsService.removeMember(groupId, userId);
        return ResponseEntity.status(200).body("Member removed successfully from the group.");
    }



    @PostMapping("/{groupId}/tasks/{type}/{taskName}/{dueDate}/{details}")
    public ResponseEntity<String> assignTaskToGroup(@PathVariable Integer groupId, @RequestParam String type, @PathVariable String taskName, @PathVariable LocalDate dueDate, @PathVariable String details) {
        groupsService.assignTaskToGroup(groupId, type, taskName, dueDate, details);
        return ResponseEntity.status(200).body("task assigned successfully");
    }



    @PostMapping("/{groupId}/tasks/{taskId}/performance/{ratingTeamPerform}")
    public ResponseEntity assignTeamPerformanceReport(@PathVariable Integer groupId, @PathVariable Integer taskId, @PathVariable int ratingTeamPerform) {
            groupsService.assignTeamPerformanceReport(groupId, taskId, ratingTeamPerform);
            return ResponseEntity.status(200).body("team performance report assigned successfully");
    }



//    @PostMapping("/groups/{groupId}/decline-invite")// decline group invite
//    public ResponseEntity<String> declineGroupInvite(@PathVariable Integer groupId) {
//        groupsService.declineGroupInvite(groupId);
//        return ResponseEntity.ok("Invitation declined successfully");
//    }

}
