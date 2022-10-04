package com.example.springBatch.batch;

import org.springframework.stereotype.Component;

@Component
public class ServiceClass {
    public String serviceMethod(Long value) throws Exception{
        System.out.println("value : "+ value);
        System.out.println("serviceMethod called");
        return "serviceMethod called";
    }
}
