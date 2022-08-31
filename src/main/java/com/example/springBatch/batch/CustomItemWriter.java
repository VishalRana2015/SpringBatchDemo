package com.example.springBatch.batch;

import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class CustomItemWriter implements ItemWriter<Object> {

    @Override
    public void write(List<? extends Object> list) throws Exception {
        System.out.println("CustomItemWriter's write method called");
        for ( Object item : list){
            System.out.println(item.toString() );
        }
        System.out.println();
    }
}
