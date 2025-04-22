package com.example.Movie_ticket_booking_system.impl;

import com.example.Movie_ticket_booking_system.Repository.Userrepository;
import com.example.Movie_ticket_booking_system.entity.TheaterOwner;
import com.example.Movie_ticket_booking_system.entity.UserDetails;
import com.example.Movie_ticket_booking_system.exception.UserExistByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.Movie_ticket_booking_system.entity.User;



    @Service
    @AllArgsConstructor
    public class UserServiceImpl implements UserService {
        private final Userrepository userrepository;

        @Override
        public UserDetails addUser(UserDetails user) {
            if (!userrepository.existsByEmail(user.getEmail())) {
                //return copy(user);
                return switch (user.getUserRole()) {
                    case USER -> copy(new User(), user);
                    case THEATER_OWNER -> copy(new TheaterOwner(), user);
                };
            }
            throw new UserExistByEmailException("user with the Email is already exists");
        }
        private UserDetails copy(UserDetails userRole,UserDetails user){

//        Userdetails userRole = user.getUserRole()== UserRole.USER? new user()
            userRole.setUserRole(user.getUserRole());
            userRole.setEmail(user.getEmail());
            userRole.setPassword(user.getPassword());
            userRole.setCreatedAt(user.getCreatedAt());
            userRole.setDateOfBirth(user.getDateOfBirth());
            userRole.setPhoneNumber(user.getPhoneNumber());
            userRole.setUsername(user.getUsername());
            userRole.setUpdatedAt(user.getUpdatedAt());
            userrepository.save(userRole);
            return userRole;
        }

    }

