package com.coding.exercise.coding_exercise;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${app.exchange}")
    private String exchangeName;

    public static final String queue1 = "queue.one";
    public static final String queue2 = "queue.two";
    public static final String queue3 = "queue.three";
    public static final String queue4 = "queue.four";
    public static final String queue5 = "backup";

    @Bean
    public DirectExchange appExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue q1(){
        return new Queue(queue1,true);
    }

    @Bean
    public Queue q2(){
        return new Queue(queue2,true);
    }
    @Bean
    public Queue q3(){
        return new Queue(queue3,true);
    }

    @Bean
    public Queue q4(){
        return new Queue(queue4,true);
    }

    @Bean
    public Queue backup(){
        return new Queue(queue5,true);
    }

    @Bean
    public Binding b1(@Qualifier("q1") Queue queue, DirectExchange ex){
        return BindingBuilder.bind(queue).to(ex).with(queue1);
    }

    @Bean
    public Binding b2(@Qualifier("q2") Queue queue, DirectExchange ex){
        return BindingBuilder.bind(queue).to(ex).with(queue2);
    }

    @Bean
    public Binding b3(@Qualifier("q3") Queue queue, DirectExchange ex){
        return BindingBuilder.bind(queue).to(ex).with(queue3);
    }

    @Bean
    public Binding b4(@Qualifier("q4") Queue queue, DirectExchange ex){
        return BindingBuilder.bind(queue).to(ex).with(queue4);
    }

    @Bean
    public Binding b5(@Qualifier("backup") Queue queue, DirectExchange ex){
        return BindingBuilder.bind(queue).to(ex).with(queue5);
    }

}
