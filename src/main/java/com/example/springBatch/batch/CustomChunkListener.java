package com.example.springBatch.batch;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class CustomChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext context) {
        System.out.println("CustomChunkListener's beforeChunk method called.");
    }

    @Override
    public void afterChunk(ChunkContext context) {
        System.out.println("CustomChunkListener's afterChunk method called");
    }

    @Override
    public void afterChunkError(ChunkContext context) {
        System.out.println("CustomChunkListener's afterChunkError method called.");
    }
}
