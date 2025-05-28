package com.pod2.wastewise.repository;

import com.pod2.wastewise.model.PickupSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface PickupScheduleRepository extends JpaRepository<PickupSchedule, String> {


    /**
     * Get total count of schedules
     */
    @Query("Select COUNT(p) from PickupSchedule p")
    long countAll();

    /**
     * Fetch all schedules for a vehicle overlap
     */
    List<PickupSchedule> findByVehicle_VehicleIdAndTimeSlot(
            String vehicleId, Timestamp startBuffer, Timestamp endBuffer);


}
