package com.pod2.wastewise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PickupSchedule {
    @Id
    private String scheduleId;

    private int frequency;

}
