package com.coding.exercise.coding_exercise;

import com.coding.exercise.coding_exercise.Model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BackUpQueue {

    private final RabbitTemplate rabbitTemplate;

    public BackUpQueue(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void backUpQueue(Message msg) {
        rabbitTemplate.convertAndSend("app.exchange", "backup", msg.getPayload());
        System.out.println("Message rerouted to Backup queue: " + msg);
    }
}
