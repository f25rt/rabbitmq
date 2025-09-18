package com.coding.exercise.coding_exercise.OrderProcessing;

import com.coding.exercise.coding_exercise.BackUpQueue;
import com.coding.exercise.coding_exercise.Listener.ChannelListenerInferface;

import com.coding.exercise.coding_exercise.Model.Message;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class OrderProcessingModule implements OrderingModule,ChannelListenerInferface{

    private final BackUpQueue backUpQueue;
    private final Map<String, ConcurrentLinkedQueue<Message>> channelQueues = new ConcurrentHashMap<>();

    // Outgoing global queue (thread-safe, blocking semantics)
    private final BlockingQueue<Message> outQueue = new LinkedBlockingQueue<>(500);

    private final BlockingQueue<Message> backupQueue = new LinkedBlockingQueue<>();

    public OrderProcessingModule(BackUpQueue backUpQueue) {
        this.backUpQueue = backUpQueue;
    }

    @Override
    public BlockingQueue<Message> getOutQueue() {
        return outQueue;
    }

    public ConcurrentLinkedQueue<Message> getChannelQueue(String channelId) {
        return channelQueues.get(channelId);
    }

    @Override
    public void messageReceived(Message message) {
        channelQueues
                .computeIfAbsent(message.getSourceChannelId(), id -> new ConcurrentLinkedQueue<>())
                .offer(message);

        System.out.println("Payload "+message.getPayload());
        boolean offered = outQueue.offer(message);

        if(!offered){
            backUpQueue.backUpQueue(message);
            System.out.println("Payload exceeded moving to backup queue "+outQueue.remainingCapacity());
        }

        System.out.println("Payload Capacity "+outQueue.remainingCapacity());
    }
}
