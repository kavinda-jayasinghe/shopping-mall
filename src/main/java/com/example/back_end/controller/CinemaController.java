package com.example.back_end.controller;

import com.example.back_end.dto.CinemaDto;
import com.example.back_end.entity.Cinema;
import com.example.back_end.service.CinemaService;
import com.example.back_end.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;


    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('CINEMA')")
    public String forUser(){
        return "This URL is only accessible to the cinema";
    }

    //CINEMA
    //create
    //*THEATER_OWNER
    @PostMapping(path = "/post-movie")
    public ResponseEntity<StandardResponse> postMovie(@RequestBody Cinema cinema){
        Cinema name= cinemaService.postMovie(cinema);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"movie successfully saved",name),
                HttpStatus.CREATED
        );
    }
    //update movie
    //*THEATER_OWNER ROLE
    @PutMapping(path={"/update/{id}"})

    public ResponseEntity<StandardResponse> updateMovie(
            @RequestBody CinemaDto cinemaDto,
            @PathVariable(value = "id") long id) throws NotFoundException {
        String updated=cinemaService.updateMovie(cinemaDto,id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"Movie successfully saved",updated),
                HttpStatus.CREATED
        );
    }

    //delete
    //*THEATER_OWNER ROLE
    @DeleteMapping("/delete-movie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") long id) {
        String message = cinemaService.deleteMovie(id);
        return ResponseEntity.ok(message);
    }


}
