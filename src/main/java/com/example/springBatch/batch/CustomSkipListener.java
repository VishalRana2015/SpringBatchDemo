package com.example.springBatch.batch;

import org.springframework.batch.core.SkipListener;
// In the angular brackets we have specified <String, String>
// Here the first String is the data type of the object that the read method of ItemReader returns and second String is the data type of the object that we give as
// a parameter to ItemWriter's write method.
public class CustomSkipListener implements SkipListener<String,String> {
    @Override
    public void onSkipInRead(Throwable t) {
        System.out.println("CustomSkipListener's onSkipInRead called.");
    }

    @Override
    public void onSkipInWrite(String item, Throwable t) {
        System.out.println("CustomSkipListener's onSkipInWrite called.");
    }

    @Override
    public void onSkipInProcess(String item, Throwable t) {
        System.out.println("CustomSkipListener's onSkipInProcess called.");
    }
}
