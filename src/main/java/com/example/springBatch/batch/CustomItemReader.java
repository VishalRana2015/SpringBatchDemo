package com.example.springBatch.batch;

import org.springframework.batch.item.ItemReader;

public class CustomItemReader implements ItemReader<String> {
    public static int itemsCount = 10;
    private int itemNumber = 0;

    public CustomItemReader() {
        itemNumber = 1;
    }

    @Override
    public String read() throws Exception {
        try{
            Thread.sleep(1000);
        }
        catch(Exception exp){
            System.out.println("Exception thrown  : "+ exp.toString());
        }
        if (itemNumber <= itemsCount) {
            String item = "item " + itemNumber++;
            System.out.println("Returning : " + item);
            return item;
        }
        return null;
    }
}
