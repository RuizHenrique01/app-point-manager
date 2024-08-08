package com.api_point_manager.api.application.exceptions;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message){
        super(message);
    }
}