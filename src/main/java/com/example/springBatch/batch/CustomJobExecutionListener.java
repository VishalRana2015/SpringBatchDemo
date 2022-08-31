package com.example.springBatch.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CustomJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("CustomJobListener's beforeJob method called.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("CustomJobListener's afterJob method called.");
        jobExecution.setStatus(BatchStatus.FAILED);
    }
}
