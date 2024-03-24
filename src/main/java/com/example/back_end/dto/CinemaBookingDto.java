package com.example.back_end.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CinemaBookingDto {

    private Long bookingId;
    private long categoryId;
    private long userId;
    private String date;
    private String time;
    private int noOfSeats;
}
