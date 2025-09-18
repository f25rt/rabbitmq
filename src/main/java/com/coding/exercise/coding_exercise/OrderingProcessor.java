package com.coding.exercise.coding_exercise;

import com.coding.exercise.coding_exercise.Model.Message;
import com.coding.exercise.coding_exercise.OrderProcessing.OrderProcessingModule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class OrderingProcessor {

    private final OrderProcessingModule orderingModule;

    public OrderingProcessor(OrderProcessingModule orderingModule) {
        this.orderingModule = orderingModule;
    }

    @PostConstruct
    public void startProcessor() {
        new Thread(() -> {
            try {
                while (true) {
                    Message msg = orderingModule.getOutQueue().take();
                    System.out.println("Processing -> " + msg);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
