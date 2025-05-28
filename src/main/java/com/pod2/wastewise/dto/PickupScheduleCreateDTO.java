package com.pod2.wastewise.dto;

import com.pod2.wastewise.model.enums.Frequency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Payload to create a pickup job.
 */
public class PickupScheduleCreateDTO {
    @NotBlank
    private String zoneId;
    
    @NotBlank
    private String timeSlot; // "HH:mm-HH:mm"
    
    @NotNull
    private Frequency frequency;
    
    @NotBlank
    private String pickupLocation;
    
    @NotBlank
    private String workerId;
    
    @NotBlank
    private String vehicleId;
    
    public String getZoneId() {
        return zoneId;
    }
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    
}
