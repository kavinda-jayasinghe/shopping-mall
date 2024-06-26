package com.example.back_end.repository;

import com.example.back_end.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
@EnableJpaRepositories

public interface CinemaRepo extends JpaRepository<Cinema,Long> {
    @Modifying
    @Query(value = "update cinema set film_name = ?1, description = ?2, show_time = ?3, img = ?4, duration = ?5, booked_seats = ?6, date = ?7, time = ?8 where id = ?9", nativeQuery = true)
    void updateMovie(String filmName, String description, String showTime, String img, String duration, int bookedSeats, String date, String time, long id);

    List<Cinema> findByFilmNameContainingIgnoreCase(String name);
}
