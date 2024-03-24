package com.example.back_end.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class BookingCinemaDto {

    private String userId;
    private String movieId;
    private String bookedDate;
    private String bookedTime;
    private double price;
    private String bookedSeats;
}
