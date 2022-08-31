package com.example.springBatch.batch;

import org.springframework.batch.core.ItemReadListener;

public class CustomItemReaderListener implements ItemReadListener<String> {

    @Override
    public void beforeRead() {
        System.out.println("CustomItemReadListener's beforeRead method called.");
    }

    @Override
    public void afterRead(String item) {
        System.out.println("CustomItemReadListener's afterRead method called.");
    }

    @Override
    public void onReadError(Exception ex) {
        System.out.println("CustomItemReadListener's onReadError method called.");
    }
}
