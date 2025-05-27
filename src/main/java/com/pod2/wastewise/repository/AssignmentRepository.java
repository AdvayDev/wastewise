package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssignmentRepository extends JpaRepository<Assignment,String> {
    @Query("Select COUNT(a) from Assignment a")
    long countAll();
}
