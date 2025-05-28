package com.pod2.wastewise.exception;

public class VehicleBusyException extends RuntimeException{
    public VehicleBusyException(){
        super("Vehicle is busy during the requested time window");
    }
}
