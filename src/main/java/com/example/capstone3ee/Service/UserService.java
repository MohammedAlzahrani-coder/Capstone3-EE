package com.example.capstone3ee.Service;

import com.example.capstone3ee.Model.User;
import com.example.capstone3ee.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // GET
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    // ADD
    public void addUser(User user) {

        userRepository.save(user);
    }

    // UPDATE
    public void updateUser(Integer id, User updatedUser) {
        User user =userRepository.findUserById(id);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setBio(updatedUser.getBio());
        user.setInterests(updatedUser.getInterests());
        user.setCareerGoals(updatedUser.getCareerGoals());
        user.setEvaluationResult(updatedUser.getEvaluationResult());
        user.setRole(updatedUser.getRole());

         userRepository.save(user);
    }

    // DELETE
    public void deleteUser(Integer id) {
        User user = userRepository.findUserById(id);
        if (user==null){
            throw new RuntimeException("user not found");
        }
        userRepository.deleteById(id);
    }
}