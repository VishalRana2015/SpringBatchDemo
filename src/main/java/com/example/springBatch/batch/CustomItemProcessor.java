package com.example.springBatch.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<String, String> {

    public CustomItemProcessor(){

    }
    @Override
    public String process(String s) throws Exception {
        return  s + "processed";
    }
}
