package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.*;
import com.example.capstone3ee.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ExpertRepository expertRepository;
    private final RatingRepository ratingRepository;
    private RequestRepository requestRepository;

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
        User user =userRepository.findUserByUsersId(id);
        if (user == null) {
            throw new ApiException("user not found");
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

    public void deleteUser(Integer id) {
        User user = userRepository.findUserByUsersId(id);
        if (user==null){
            throw new ApiException("user not found");
        }
        userRepository.deleteById(id);
    }
// -------------------------------------- end point ----------------------------------------------------

    // استشارة : by nora
    public void createRequest(Integer userId, Integer expertId, String requestDescription) {
        User user = userRepository.findUserByUsersId(userId);
        Expert expert = expertRepository.findExpertByExpertId(expertId);
        if (user == null) {
            throw new ApiException("User not found");
        }
        if (expert == null) {
            throw new ApiException("Expert not found");
        }
        Request request = new Request();
        request.setUser(user);
        request.setExpert(expert);
        request.setRequestDescription(requestDescription);
        requestRepository.save(request);
    }



}