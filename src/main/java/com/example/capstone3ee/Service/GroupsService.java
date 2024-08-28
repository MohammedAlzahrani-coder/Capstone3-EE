package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.*;
import com.example.capstone3ee.Repository.ExpertRepository;
import com.example.capstone3ee.Repository.GroupsRepository;
import com.example.capstone3ee.Repository.TaskRepository;
import com.example.capstone3ee.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Group;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service @RequiredArgsConstructor
public class GroupsService {
    private final GroupsRepository groupsRepository;
    private final UserRepository userRepository;
    private final ExpertRepository expertRepository;
    private final TaskRepository taskRepository;
    //  private final ExpertRepository expertRepository;


    public List<Groups> getAllGroup() {
        return groupsRepository.findAll();
    }


    public void addGroup(Groups group) {
        groupsRepository.save(group);
    }

    public void updateGroup(Integer id, Groups group) {
        Groups group1 = groupsRepository.findGroupByGroupId(id);

        if (group1 == null) {
            throw new ApiException("group not found");
        }
        group1.setName(group.getName());
        group1.setDescription(group.getDescription());
        group1.setApplicable(group.isApplicable());
        group1.setProjects(group.getProjects());
        group1.setMembers(group.getMembers());
        groupsRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        Groups group = groupsRepository.findGroupByGroupId(id);
        if (group == null) {
            throw new ApiException("group not found");
        }
        groupsRepository.delete(group);
    }

    //List<Integer> // assign users to group
    public void assignUsersToGroups(Integer groupId, Integer userIds) {
        Groups group = groupsRepository.findGroupByGroupId(groupId);
        User users = userRepository.findUserByUsersId(userIds);
        if (group == null) {
            throw new ApiException("group not found");
        }
        if (users == null) {
            throw new ApiException("user not found");
        }
        group.getUsers().add(users);
        users.getGroups().add(group);
        userRepository.save(users);
        groupsRepository.save(group);
    }


    // ------------------------------------- End point ---------------------------------------
    // remove members from group  : by Nora
    public void removeMember(Integer groupId, Integer userId) {
        Groups group = groupsRepository.findGroupByGroupId(groupId);
        User user = userRepository.findUserByUsersId(userId);

        if (group == null) {
            throw new ApiException("group not found");
        }
        if (user == null || !group.getMembers().contains(user)) {
            throw new ApiException("User not found in the group");
        }
        if (user.getRole().equals("admin")) {
            group.getMembers().remove(user);
        } else {
            throw new ApiException("User is not an admin");
        }
        groupsRepository.save(group);
    }


    // assign task to group by Nora
    public String assignTaskToGroup(Integer groupId, String type, String taskName, LocalDate dueDate, String details) {
        Groups group = groupsRepository.findById(groupId)
                .orElseThrow(() -> new ApiException("Group not found"));

        if (!group.getGroupType().equals(type)) {
            throw new ApiException("Task does not match group domain");
        }

        if (group.getTasks() == null) {
            group.setTasks(new HashSet<>());
        }

        Tasks task = new Tasks();
        task.setTaskName(taskName);
        task.setDueDate(dueDate);
        task.setDetails(details);

        group.getTasks().add(task);
        groupsRepository.save(group);
        return "Task assigned to group";
    }



    // تعيين تقرير أداء الفريق : by nora
    public String assignTeamPerformanceReport(Integer groupId, Integer taskId, int ratingTeamPerform) {
        Groups group = groupsRepository.findGroupByGroupId(groupId);
        Tasks task = taskRepository.findTaskByTaskId(taskId);

        if (group == null) {
            throw new ApiException("Group not found");
        }
        if (task == null) {
            throw new ApiException("Task not found");
        }
        if (group.getTasks().isEmpty()) {
            throw new ApiException("Tasks not found in the group");
        }
        if (group.getTeamPerformance() != 0) {
            throw new ApiException("Team performance rating already assigned for this group");
        }
        group.setTeamPerformance(ratingTeamPerform);
        task.setTeamPerformanceRating(ratingTeamPerform);
        groupsRepository.save(group);
        taskRepository.save(task);
        return "Team performance report assigned successfully.";
    }



//        public void declineGroupInvite(Integer groupId) {
//           Groups groups = groupsRepository.findGroupByGroupId(groupId);
//           if(groups == null){
//               throw new ApiException("group not found");
//           } System.out.println("Invitation declined for group with ID: " + groupId);
//        }


}