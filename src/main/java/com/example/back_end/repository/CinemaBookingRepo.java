package com.example.back_end.repository;

import com.example.back_end.entity.CinemaBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaBookingRepo extends JpaRepository<CinemaBooking,Long> {
}
