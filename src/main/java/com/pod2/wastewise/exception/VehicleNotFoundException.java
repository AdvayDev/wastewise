package com.pod2.wastewise.exception;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(String id){
        super("Vehicle with id " + id + " not found");
    }
}
