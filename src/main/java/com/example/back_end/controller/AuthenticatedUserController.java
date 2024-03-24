package com.example.back_end.controller;

import com.example.back_end.dto.CinemaBookingDto;
import com.example.back_end.dto.CinemaBookingPaymentDto;
import com.example.back_end.entity.Cinema;
import com.example.back_end.entity.Feedback;
import com.example.back_end.service.BookingService;
import com.example.back_end.service.CinemaService;
import com.example.back_end.service.FeedbackService;
import com.example.back_end.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authenticated-user")
@CrossOrigin(origins = "http://localhost:4200")
//if user(customers & sellers) is logged in to the system
public class AuthenticatedUserController {
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private BookingService bookingService;

    //--------------------------------------------CINEMA-------------------------------------
    //get all movies
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Cinema>> getAllMovies() {
        List<Cinema> movies = cinemaService.getAllMovies();
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(movies);
        }
    }


    //get by name
    @GetMapping("/search-by-name/{name}")
    public ResponseEntity<List<Cinema>> getByName(@PathVariable String name) {
        List<Cinema> movies = cinemaService.searchMoviesByName(name);

        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(movies);
        }
    }

    //--------------------------------------------------------------FEEDBACK

    //add feed back
    @PostMapping("/feed-back/{userId}/{categoryId}")
    public Feedback addFeedbackForItem(@PathVariable long userId, @PathVariable long categoryId, @RequestBody Feedback feedback) {
        return feedbackService.addFeedback(userId, categoryId, feedback);
    }
    //get all feed back

    @GetMapping("/get-all-feed-back")
    public List<Object[]> getAllFeedbackWithUserNames() {
        return feedbackService.getAllFeedbackWithUserName();
    }

    @DeleteMapping("/{feedbackId}")
    public void deleteFeedback(@PathVariable Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }

    @PutMapping("/{feedbackId}")
    public Feedback updateFeedback(@PathVariable Long feedbackId, @RequestBody Feedback updatedFeedback) {
        return feedbackService.updateFeedback(feedbackId, updatedFeedback);
    }

//--------------------------------------------------------------payment

    //save


    @PostMapping(path = "/booking-payment")
    public ResponseEntity<String> payment(
                                          @RequestBody CinemaBookingPaymentDto cinemaBookingPaymentDto) {
        bookingService.saveBookingAndPayment( cinemaBookingPaymentDto);
        return ResponseEntity.status(HttpStatus.OK).body("Data saved successfully");
    }

}


