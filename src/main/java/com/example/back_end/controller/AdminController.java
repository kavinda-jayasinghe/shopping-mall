package com.example.back_end.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {


@GetMapping({"/forAdmin"})
@PreAuthorize("hasRole('Admin')")
public String forAdmin(){
    return "This URL is only accessible to the admin";
}

}
