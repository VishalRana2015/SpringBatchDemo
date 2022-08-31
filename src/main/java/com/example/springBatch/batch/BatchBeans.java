package com.example.springBatch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
                .chunk(2)
                .reader(new CustomItemReader())
                .writer(new CustomItemWriter())
                .build();
    }

    @Bean(name = "job1")
    public Job job1(){
        return jobBuilderFactory.get("job1")
                .start(step1())
                .build();
    }
}
