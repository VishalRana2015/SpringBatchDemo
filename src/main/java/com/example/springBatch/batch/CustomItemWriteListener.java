package com.example.springBatch.batch;

import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class CustomItemWriteListener implements ItemWriteListener<String > {
    @Override
    public void beforeWrite(List<? extends String> items) {
        System.out.println("CustomItemWriteListener's beforeWrite method called.");
    }

    @Override
    public void afterWrite(List<? extends String> items) {
        System.out.println("CustomItemWriteListener's afterWrite method called.");
    }

    @Override
    public void onWriteError(Exception exception, List<? extends String> items) {
        System.out.println("CustomItemWriteListener's onWriteError method called.");
    }
}
