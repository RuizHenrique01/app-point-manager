package com.api_point_manager.api.application.exceptions;

public class ForbiddenException extends RuntimeException {
    
    public ForbiddenException(String message){
        super(message);
    }
}