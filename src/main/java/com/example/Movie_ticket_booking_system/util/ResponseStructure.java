package com.example.Movie_ticket_booking_system.util;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class ResponseStructure<T>{
    private int StatusCode;
    private String message;
    private T data;
}
