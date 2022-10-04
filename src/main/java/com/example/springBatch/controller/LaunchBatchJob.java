package com.example.springBatch.controller;

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
public class LaunchBatchJob {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("customerJob")
    Job customerJob;

    @GetMapping("/launchCustomerJob")
    public ResponseEntity<String> launchCustomerJob(@RequestParam(name="name", required = true) String name, @RequestParam(name="id", required = true) String id) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters  = new JobParametersBuilder().addString("name", name).addString("id", id).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(customerJob, jobParameters);
        return new ResponseEntity<>(jobExecution.toString(), HttpStatus.OK);
    }
}
