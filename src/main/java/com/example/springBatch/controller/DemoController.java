package com.example.springBatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    @Qualifier("job1")
    Job job;
    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("Webiste is working." , HttpStatus.OK);
    }

    public ResponseEntity<String> isJobExist(){
        String response = "Job doesn't not exist";
        if ( job != null)
            response = "job exists";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
