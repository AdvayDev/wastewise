package com.pod2.wastewise.exception;

public class RoleDoesNotExistException extends RuntimeException{
    public RoleDoesNotExistException(String message){
        super(message);
    }
}
