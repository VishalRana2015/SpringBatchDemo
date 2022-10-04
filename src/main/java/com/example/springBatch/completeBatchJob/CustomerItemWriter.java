package com.example.springBatch.completeBatchJob;

import com.example.springBatch.domain.Customer;
import com.example.springBatch.domain.CustomerCopy;
import com.example.springBatch.repo.CustomerCopyRepo;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerItemWriter implements ItemWriter<Object> {
   private CustomerCopyRepo customerCopyRepo;
   private StepExecution stepExecution;
   // These annotation makes the instances of this class as an instances of StepExecutionListener by making this class as a subclass of StepExecutionListener at the compilation time.
    // If ItemReader or ItemProcessor or ItemWriter are instances of StepExecutionListener then job register them by default.
   @BeforeStep
   public void beforeStep(StepExecution stepExecution){
       this.stepExecution = stepExecution;
   }
    public CustomerItemWriter(CustomerCopyRepo customerCopyRepo){
        this.customerCopyRepo = customerCopyRepo;
    }
    @Override
    public void write(List<? extends Object> list) throws Exception {
        System.out.println("In write method of CustomerItemWriter");
        List<Customer> customers =(List<Customer>)list;
        for ( Customer customer : customers){
            CustomerCopy copy = new CustomerCopy();
            copy.setName(customer.getName());
            customerCopyRepo.save(copy);
            ExecutionContext executionContext = stepExecution.getExecutionContext();
            executionContext.put(customer.getId().toString(), customer.getName());
        }
    }
}
