package com.example.springBatch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchBeans {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean(name = "step1")
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .<String,String>chunk(3)
                .reader(new CustomItemReader())
                .processor(new CustomItemProcessor())
                .writer(new CustomItemWriter())
                .listener(new CustomChunkListener())
                .listener(new CustomItemWriteListener())
                .listener(new CustomItemProcessListener())
                .listener(new CustomStepExecutionListener())
                .listener(new CustomItemReaderListener())
                .startLimit(2)
                .allowStartIfComplete(true)
                .build();
    }

    @Bean(name = "job1")
    public Job job1(){
        return jobBuilderFactory.get("job1")
                .listener(new CustomJobExecutionListener())
                .start(step1())
                .build();
    }
}
