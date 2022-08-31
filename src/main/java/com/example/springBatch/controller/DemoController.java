package com.example.springBatch.controller;

import com.sun.net.httpserver.HttpsServer;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("job1")
    Job job1;


    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("Website is working." , HttpStatus.OK);
    }

    @GetMapping("/isJob")
    public ResponseEntity<String> isJobExist(){
        String response = "Job doesn't not exist";
        if ( job1 != null)
            response = "job exists";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/launchJob1")
    public ResponseEntity<String> launchJob1(@RequestParam(name = "name", required = true) String name) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", name).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job1, jobParameters);
        return new ResponseEntity<String> ( jobExecution.toString(),HttpStatus.OK);
    }
}
