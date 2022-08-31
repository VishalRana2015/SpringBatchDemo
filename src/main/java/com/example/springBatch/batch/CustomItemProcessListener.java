package com.example.springBatch.batch;

import org.springframework.batch.core.ItemProcessListener;

public class CustomItemProcessListener implements ItemProcessListener<String,String> {
    @Override
    public void beforeProcess(String item) {
        System.out.println("CustomItemProcessListener's beforeProcess method called.");
    }

    @Override
    public void afterProcess(String item, String result) {
        System.out.println("CustomItemProcessListener's afterProcess method called.");
    }

    @Override
    public void onProcessError(String item, Exception e) {
        System.out.println("CustomItemProcessListener's onProcessError method called.");
    }
}
