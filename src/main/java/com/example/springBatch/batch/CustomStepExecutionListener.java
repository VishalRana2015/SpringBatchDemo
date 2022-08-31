package com.example.springBatch.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class CustomStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("CustomStepExecutionListener's beforeStep method called.");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("CustomStepExecutionListener's afterStep method called.");
        return stepExecution.getExitStatus();
    }
}
