package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkerRepository extends JpaRepository<Worker,String> {
    @Query("Select COUNT(w) from Worker w")
    long countAll();
}
