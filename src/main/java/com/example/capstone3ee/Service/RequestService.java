package com.example.capstone3ee.Service;

import com.example.capstone3ee.Model.Request;
import com.example.capstone3ee.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    // GET
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    // ADD
    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    // UPDATE
    public Request updateRequest(Integer id, Request updatedRequest) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setUser_id(updatedRequest.getUser_id());
        request.setExpert_id(updatedRequest.getExpert_id());
        request.setStatus(updatedRequest.getStatus());

        return requestRepository.save(request);
    }

    // DELETE
    public void deleteRequest(Integer id) {
        requestRepository.deleteById(id);
    }
}
