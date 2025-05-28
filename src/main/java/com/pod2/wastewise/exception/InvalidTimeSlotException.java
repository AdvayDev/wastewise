package com.pod2.wastewise.exception;

public class InvalidTimeSlotException extends RuntimeException{
    public InvalidTimeSlotException(String message){
        super(message);
    }
}
