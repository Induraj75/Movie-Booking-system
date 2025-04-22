package com.example.Movie_ticket_booking_system.exception.handler;

import com.example.Movie_ticket_booking_system.exception.UserExistByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.Movie_ticket_booking_system.util.ErrorStructure;
import com.example.Movie_ticket_booking_system.util.RestResponseBuilder;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {
    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handlerUserExistByEmailException(UserExistByEmailException ex){
        return responseBuilder.error(HttpStatus.OK, ex.getMessage());
    }
}
