package com.example.springBatch.completeBatchJob;

import com.example.springBatch.domain.Customer;
import com.example.springBatch.domain.CustomerCopy;
import com.example.springBatch.repo.CustomerCopyRepo;
import com.example.springBatch.repo.CustomerRepo;
import org.springframework.batch.core.*;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.*;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;
import java.util.function.Function;

@Configuration
public class BatchJobs {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerCopyRepo customerCopyRepo;

    @Bean(name = "customerJob")
    Job customerJob(){
        return jobBuilderFactory.get("customerJob")
                .start(customerJobStep1())
                .next(customerJobStep3())
                .build();
    }

    @Bean(name= "customerJobStep1")
    Step customerJobStep1(){
        return stepBuilderFactory.get("customerJobStep1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("In customerJobStep1");
                        List<Customer> list  = customerRepo.findAll();
                        ExecutionContext jobExecutionContext = contribution.getStepExecution().getJobExecution().getExecutionContext();
                        List<Integer> ids = new ArrayList<>();
                        for ( Customer customer : list){
                            ids.add(customer.getId());
                        }
                        jobExecutionContext.put("ids", ids);

                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    Step customerJobStep2(){
        return stepBuilderFactory.get("customerJobStep2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("In customerJobStep2");
                        ExecutionContext executionContext = contribution.getStepExecution().getJobExecution().getExecutionContext();
                        Object object = executionContext.get("ids");
                        System.out.println("Printing ids");
                        System.out.println(object.toString());
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    Step customerJobStep3(){
        return stepBuilderFactory.get("customerJobStep2")
                .chunk(2)
                .reader(new ItemReader<Customer>() {
                    private StepExecution stepExecution;
                    List<Integer> list ;
                    private int count =0;
                    @BeforeStep
                    public void beforeStep(StepExecution stepExecution){
                        this.stepExecution = stepExecution;
                        this.list = (List<Integer>)this.stepExecution.getJobExecution().getExecutionContext().get("ids");
                    }
                    @Override
                    public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                        if ( count < list.size()){
                            Optional<Customer> customer = customerRepo.findById(list.get(count++));
                            if ( customer.isPresent())
                                return customer.get();
                        }
                        return null;
                    }
                })
                //.processor((Function<? super Object, ?>) new CustomerItemProcessor())
                .writer(new CustomerItemWriter(customerCopyRepo))
                .build();
    }

}
