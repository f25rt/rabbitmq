package com.coding.exercise.coding_exercise.OrderProcessing;


import com.coding.exercise.coding_exercise.Model.Message;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public interface OrderingModule {
    BlockingQueue<Message> getOutQueue();
}
