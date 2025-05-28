package com.pod2.wastewise.dto;

import jakarta.validation.constraints.NotBlank;

public class PickupScheduleDeleteDTO {
    @NotBlank
    private String scheduleId;


    public String getScheduleId() {
        return scheduleId;
    }
        public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
}
