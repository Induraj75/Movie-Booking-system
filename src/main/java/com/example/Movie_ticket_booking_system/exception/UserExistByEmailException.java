package com.example.Movie_ticket_booking_system.exception;

import lombok.Getter;

@Getter
public class UserExistByEmailException extends RuntimeException {
    private String message;
    public UserExistByEmailException(String message){
        this.message=message;
    }
}
