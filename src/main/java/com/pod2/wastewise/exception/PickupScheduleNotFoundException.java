package com.pod2.wastewise.exception;

public class PickupScheduleNotFoundException extends RuntimeException{
    public PickupScheduleNotFoundException(String id){
        super("Pickup schedule with id " + id + " not found");
    }
}
