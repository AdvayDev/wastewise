package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,String> {

}
