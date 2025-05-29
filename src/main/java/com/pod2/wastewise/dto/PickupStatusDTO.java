package com.pod2.wastewise.dto;


import com.pod2.wastewise.model.enums.PickupStatus;

import java.sql.Timestamp;

public class PickupStatusDTO {
    private final String vehicleId;
    private PickupStatus status;
    private final String scheduleId;
    private final String pickupLocation;
    private final Timestamp startTime;
    private final Timestamp endTime;

    public PickupStatusDTO(String vehicleId, PickupStatus status, String scheduleId, String pickupLocation, Timestamp startTime, Timestamp endTime) {
        this.vehicleId = vehicleId;
        this.status = status;
        this.scheduleId = scheduleId;
        this.pickupLocation = pickupLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public PickupStatus getStatus() {
        return status;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

}
