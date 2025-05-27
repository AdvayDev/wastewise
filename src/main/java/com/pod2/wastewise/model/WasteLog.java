package com.pod2.wastewise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class WasteLog {
    @Id
    private String logId;

    private float weightCollected;
    private Timestamp collectionStartTime;
    private Timestamp collectionEndTime;

    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public WasteLog(){}

    public WasteLog(String logId, float weightCollected,
                    Timestamp collectionStartTime, Timestamp collectionEndTime,
                    String createdBy, LocalDateTime createdDate,
                    String updatedBy, LocalDateTime updatedDate,
                    Zone zone, Vehicle vehicle,
                    Worker worker) {
        super();
        this.logId = logId;
        this.weightCollected = weightCollected;
        this.collectionStartTime = collectionStartTime;
        this.collectionEndTime = collectionEndTime;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.zone = zone;
        this.vehicle = vehicle;
        this.worker = worker;
    }

    public float getWeightCollected() {
        return weightCollected;
    }

    public void setWeightCollected(float weightCollected) {
        this.weightCollected = weightCollected;
    }

    public Timestamp getCollectionStartTime() {
        return collectionStartTime;
    }

    public void setCollectionStartTime(Timestamp collectionStartTime) {
        this.collectionStartTime = collectionStartTime;
    }

    public Timestamp getCollectionEndTime() {
        return collectionEndTime;
    }

    public void setCollectionEndTime(Timestamp collectionEndTime) {
        this.collectionEndTime = collectionEndTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
