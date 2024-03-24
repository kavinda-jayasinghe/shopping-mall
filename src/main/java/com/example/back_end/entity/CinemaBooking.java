package com.example.back_end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    private String bookingDate;
    private String bookingTime;
    private int numberOfSeatsBooked;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

}