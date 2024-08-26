package com.example.capstone3ee.Repository;

import com.example.capstone3ee.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    Request findRequestById(Integer id);
}
