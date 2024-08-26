package com.example.capstone3ee.Controller;


import com.example.capstone3ee.Model.Request;
import com.example.capstone3ee.Service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    // GET all requests
    @GetMapping("/get")
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    // ADD a new request
    @PostMapping("/add")
    public ResponseEntity<Request> addRequest(@RequestBody Request request) {
        requestService.addRequest(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    // UPDATE an existing request
    @PutMapping("/update/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable Integer id, @RequestBody Request updatedRequest) {
        Request request = requestService.updateRequest(id, updatedRequest);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    // DELETE a request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Integer id) {
        requestService.deleteRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
