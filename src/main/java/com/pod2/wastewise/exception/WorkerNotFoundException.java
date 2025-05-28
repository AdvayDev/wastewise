package com.pod2.wastewise.exception;

public class WorkerNotFoundException extends RuntimeException{

    /**
     * Handles the exception when worker is not available in the database
     * @param message
     */

    public WorkerNotFoundException(String message){
        super(message);
    }
}
