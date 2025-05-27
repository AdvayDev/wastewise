package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.WorkerAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkerAssignmentRepository extends JpaRepository<WorkerAssignment,String> {
    @Query("Select COUNT(w) from WorkerAssignment w")
    long countAll();
}
