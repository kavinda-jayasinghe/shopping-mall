package com.example.back_end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    private long categoryId;
    private long userId;
    private String date;
    private String time;
    private int noOfSeats;

}