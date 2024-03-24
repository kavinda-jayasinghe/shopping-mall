package com.example.back_end.service;

import com.example.back_end.dto.CinemaBookingDto;
import com.example.back_end.dto.CinemaBookingPaymentDto;
import com.example.back_end.dto.PaymentDto;
import com.example.back_end.entity.CinemaBooking;
import com.example.back_end.entity.Payment;
import com.example.back_end.repository.CinemaBookingRepo;
import com.example.back_end.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private CinemaBookingRepo cinemaBookingRepo;

    public void saveBookingAndPayment(CinemaBookingPaymentDto cinemaBookingPaymentDto) {
        PaymentDto paymentDto = cinemaBookingPaymentDto.getPaymentDto();
        CinemaBookingDto cinemaBookingDto = cinemaBookingPaymentDto.getCinemaBookingDto();

        Payment payment = new Payment();
        payment.setUserId(paymentDto.getUserId());
        payment.setCategoryId(paymentDto.getCategoryId());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentTime(paymentDto.getPaymentTime());
        payment.setAmount(paymentDto.getAmount());
        paymentRepo.save(payment);

        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.setUserId(cinemaBookingDto.getUserId());
        cinemaBooking.setCategoryId(cinemaBookingDto.getCategoryId());
        cinemaBooking.setDate(cinemaBookingDto.getDate());
        cinemaBooking.setTime(cinemaBookingDto.getTime());
        cinemaBooking.setNoOfSeats(cinemaBookingDto.getNoOfSeats());
        cinemaBookingRepo.save(cinemaBooking);
    }
}
