package com.example.springBatch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("Webiste is working." , HttpStatus.OK);
    }

}
