package com.example.back_end.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CinemaBookingPaymentDto {

    private PaymentDto paymentDto;
    private CinemaBookingDto cinemaBookingDto;
}
