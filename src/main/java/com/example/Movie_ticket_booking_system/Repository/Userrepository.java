package com.example.Movie_ticket_booking_system.Repository;

import com.example.Movie_ticket_booking_system.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<UserDetails,Long> {
    boolean existsByEmail(String email);
}
