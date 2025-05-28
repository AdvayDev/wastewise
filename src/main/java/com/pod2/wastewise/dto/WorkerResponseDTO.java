package com.pod2.wastewise.dto;

import com.pod2.wastewise.model.Role;
import com.pod2.wastewise.model.enums.WorkerStatus;

import java.time.LocalDateTime;

public class WorkerResponseDTO {
    private String workerId;

    private String name;
    private String contactNumber;
    private String contactEmail;

    private WorkerStatus workerStatus;

    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime upadatedDate;

    private Role role;

    public WorkerResponseDTO(){}

    public WorkerResponseDTO(String workerId, String name, String contactNumber, String contactEmail, WorkerStatus workerStatus, String createdBy, LocalDateTime createdDate, String updatedBy, LocalDateTime upadatedDate, Role role) {
        super();
        this.workerId = workerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.workerStatus = workerStatus;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.upadatedDate = upadatedDate;
        this.role = role;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public WorkerStatus getWorkerStatus() {
        return workerStatus;
    }

    public void setWorkerStatus(WorkerStatus workerStatus) {
        this.workerStatus = workerStatus;
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

    public LocalDateTime getUpadatedDate() {
        return upadatedDate;
    }

    public void setUpadatedDate(LocalDateTime upadatedDate) {
        this.upadatedDate = upadatedDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
