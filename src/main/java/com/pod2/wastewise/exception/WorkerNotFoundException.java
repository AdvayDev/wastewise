package com.pod2.wastewise.exception;

public class WorkerNotFoundException extends RuntimeException{

    public WorkerNotFoundException(String id){
        super("Worker with id " + id + " not found");
    }
}
