package com.pod2.wastewise.exception;

public class ZoneNotFoundException extends RuntimeException{

    public ZoneNotFoundException(String id){
        super("Zone with id " + id + " not found");
    }
}
