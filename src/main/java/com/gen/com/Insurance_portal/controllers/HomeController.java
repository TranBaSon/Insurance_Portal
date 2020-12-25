package com.gen.com.Insurance_portal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ResponseEntity<?> Home() {
        return new ResponseEntity<>("Hello 222!", HttpStatus.OK);
    }


}
