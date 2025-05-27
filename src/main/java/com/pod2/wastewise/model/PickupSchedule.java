package com.pod2.wastewise.model;

import com.pod2.wastewise.model.enums.Frequency;
import com.pod2.wastewise.model.enums.PickupStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
public class PickupSchedule {
    @Id
    private String scheduleId;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    private Timestamp timeSlotStartTime;
    private Timestamp timeSlotEndTime;
    private PickupStatus status;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public PickupSchedule(){}

    public PickupSchedule(String scheduleId, Frequency frequency,
                          Timestamp timeSlotStartTime, Timestamp timeSlotEndTime,
                          PickupStatus status, Zone zone,
                          Worker worker, Vehicle vehicle) {
        super();
        this.scheduleId = scheduleId;
        this.frequency = frequency;
        this.timeSlotStartTime = timeSlotStartTime;
        this.timeSlotEndTime = timeSlotEndTime;
        this.status = status;
        this.zone = zone;
        this.worker = worker;
        this.vehicle = vehicle;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Timestamp getTimeSlotStartTime() {
        return timeSlotStartTime;
    }

    public void setTimeSlotStartTime(Timestamp timeSlotStartTime) {
        this.timeSlotStartTime = timeSlotStartTime;
    }

    public Timestamp getTimeSlotEndTime() {
        return timeSlotEndTime;
    }

    public void setTimeSlotEndTime(Timestamp timeSlotEndTime) {
        this.timeSlotEndTime = timeSlotEndTime;
    }

    public PickupStatus getStatus() {
        return status;
    }

    public void setStatus(PickupStatus status) {
        this.status = status;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
