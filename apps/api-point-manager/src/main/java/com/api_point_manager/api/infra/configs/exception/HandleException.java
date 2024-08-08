package com.api_point_manager.api.infra.configs.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api_point_manager.api.application.exceptions.NotFoundException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity hanldeEntityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataError::new));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(new ResponseError(ex.getMessage()));
    }

    private record DataError(String field, String message) {
        public DataError(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    private record ResponseError(String message) {
    }
}
