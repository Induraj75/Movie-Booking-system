package com.example.Movie_ticket_booking_system.controller;

import com.example.Movie_ticket_booking_system.entity.UserDetails;
import com.example.Movie_ticket_booking_system.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Movie_ticket_booking_system.util.ResponseStructure;
import com.example.Movie_ticket_booking_system.util.RestResponseBuilder;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserDetails>> addUser(@RequestBody UserDetails user){
        UserDetails userDetails = userService.addUser(user);
        return responseBuilder.success(HttpStatus.OK, "New user Details has been added",userDetails);
    }
}
