package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
    @Query("Select COUNT(v) from Vehicle v")
    long countAll();
}
