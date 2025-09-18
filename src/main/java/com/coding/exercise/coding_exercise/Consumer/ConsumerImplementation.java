package com.coding.exercise.coding_exercise.Consumer;

import com.coding.exercise.coding_exercise.Model.Message;
import com.coding.exercise.coding_exercise.OrderProcessing.OrderProcessingModule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerImplementation implements Consumer{

    private final OrderProcessingModule orderingModule;

    public ConsumerImplementation(OrderProcessingModule orderingModule) {
        this.orderingModule = orderingModule;
    }

    @Override
    @RabbitListener(queues = "queue.one")
    public void listenChannelQ1(String msg) {
        orderingModule.messageReceived(new Message("queue.one",msg));
    }

    @Override
    @RabbitListener(queues = "queue.two")
    public void listenChannelQ2(String msg) {
        orderingModule.messageReceived(new Message("queue.two",msg));
    }

    @Override
    @RabbitListener(queues = "queue.three")
    public void listenChannelQ3(String msg) {
        orderingModule.messageReceived(new Message("queue.three",msg));
    }

    @Override
    @RabbitListener(queues = "queue.four")
    public void listenChannelQ4(String msg) {
        orderingModule.messageReceived(new Message("queue.four",msg));
    }

    @Override
    @RabbitListener(queues = "backup")
    public void listenChannelBackup(String msg) {
        orderingModule.messageReceived(new Message("backup",msg));
    }
}
