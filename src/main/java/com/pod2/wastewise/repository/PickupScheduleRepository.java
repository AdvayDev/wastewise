package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.PickupSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PickupScheduleRepository extends JpaRepository<PickupSchedule, String> {
    @Query("Select COUNT(p) from PickupSchedule p")
    long countAll();
}
