package com.pod2.wastewise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.time.LocalDateTime;

@Entity
public class Zone {
    @Id
    private String zoneId;

    private String zoneName;
    private Long areaCoverage;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;


    public Zone(){}

    public Zone(String zoneId, String zoneName,
                Long areaCoverage, String createdBy,
                LocalDateTime createdDate, String updatedBy,
                LocalDateTime updatedDate) {
        super();
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.areaCoverage = areaCoverage;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getAreaCoverage() {
        return areaCoverage;
    }

    public void setAreaCoverage(Long areaCoverage) {
        this.areaCoverage = areaCoverage;
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
}
