package com.example.springBatch.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomTasklet implements Tasklet {
    private ServiceClass serviceClass;
    public CustomTasklet(ServiceClass serviceClass){
        this.serviceClass = serviceClass;
    }

    public static int REPEAT = 5;
    private int count = 0;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("execute method called of CustomTasklet");
        if ( count < REPEAT){
            System.out.println(count + " < " + REPEAT);
            serviceClass.serviceMethod(23L);
            count++;
            return RepeatStatus.CONTINUABLE;
        }
        else
            return RepeatStatus.FINISHED;
    }
}
