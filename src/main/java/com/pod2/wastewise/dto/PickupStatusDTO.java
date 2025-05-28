package com.pod2.wastewise.dto;


import com.pod2.wastewise.model.enums.VehicleStatus;

import java.sql.Timestamp;

public class PickupStatusDTO {
    private String vehicleId;
    private VehicleStatus status;
    private String scheduleId;
    private String pickupLocation;
    private Timestamp startTime;
    private Timestamp endTime;

    public PickupStatusDTO(String vehicleId, VehicleStatus status, String scheduleId, String pickupLocation, Timestamp startTime, Timestamp endTime) {
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

    public VehicleStatus getStatus() {
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
