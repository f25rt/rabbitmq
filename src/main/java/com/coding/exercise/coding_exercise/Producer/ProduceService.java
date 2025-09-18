package com.coding.exercise.coding_exercise.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceService implements ProduceInterface{

    private final RabbitTemplate rabbitTemplate;
    private final String exchange = "app.exchange";

    public ProduceService(RabbitTemplate rt){
        this.rabbitTemplate = rt;
    }

    @Override
    public void sendToChannelOne( String msg) {
        rabbitTemplate.convertAndSend(exchange, "queue.one", msg);
    }

    @Override
    public void sendToChannelTwo(String msg) {
        rabbitTemplate.convertAndSend(exchange, "queue.two", msg);
    }

    @Override
    public void sendToChannelThree(String msg) {
        rabbitTemplate.convertAndSend(exchange, "queue.three", msg);
    }

    @Override
    public void sendToChannelFour(String msg) {
        rabbitTemplate.convertAndSend(exchange, "queue.four", msg);
    }

    @Override
    public void sendToChannelBackup(String msg) {
        rabbitTemplate.convertAndSend(exchange, "backup", msg);
    }
}
