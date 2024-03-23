package com.example.back_end.controller;

import com.example.back_end.entity.Cinema;
import com.example.back_end.service.SellerService;
import com.example.back_end.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

@Autowired
private SellerService sellerService;


    @GetMapping({"/forCinema"})
    @PreAuthorize("hasRole('CINEMA')")
    public String forAdmin(){
        return "This URL is only accessible to the CINEMA";

    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
