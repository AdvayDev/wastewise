package com.pod2.wastewise.model;

import com.pod2.wastewise.model.enums.Shift;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class WorkerAssignment {
    @Id
    private String assignmentId;

    @Id
    private String workerId;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "assignment_id", insertable = false, updatable = false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "worker_id", insertable = false, updatable = false)
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public WorkerAssignment(){}

    public WorkerAssignment(String assignmentId, String workerId,
                            Shift shift, String createdBy,
                            LocalDateTime createdDate, String updatedBy,
                            LocalDateTime updatedDate, Assignment assignment,
                            Worker worker, Zone zone) {
        super();
        this.assignmentId = assignmentId;
        this.workerId = workerId;
        this.shift = shift;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.assignment = assignment;
        this.worker = worker;
        this.zone = zone;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
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

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "WorkerAssignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", workerId='" + workerId + '\'' +
                ", shift=" + shift +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", assignment=" + assignment +
                ", worker=" + worker +
                ", zone=" + zone +
                '}';
    }
}
