package com.example.springBatch.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class CustomTasklet2 implements Tasklet {
    public static int repeat = 3;
    private int count = 0;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("CustomTasklet2's execute method called.");
        if ( count < repeat){
            count++;
            return RepeatStatus.CONTINUABLE;
        }
        return RepeatStatus.FINISHED;
    }
}
