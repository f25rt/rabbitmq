package com.coding.exercise.coding_exercise;

import com.coding.exercise.coding_exercise.OrderProcessing.OrderProcessingModule;
import com.coding.exercise.coding_exercise.Producer.ProduceService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class CodingExerciseApplication  implements CommandLineRunner{
	private final ProduceService producer;
	private final OrderProcessingModule orderProcessingModule;

    public CodingExerciseApplication(ProduceService producer, OrderProcessingModule orderProcessingModule) {
        this.producer = producer;
        this.orderProcessingModule = orderProcessingModule;
    }

    public static void main(String[] args) {
		SpringApplication.run(CodingExerciseApplication.class, args);
	}


	@Override
	public void run(String... args) throws IOException {
		producer.sendToChannelOne("Channel 1 is open");
		producer.sendToChannelTwo("Channel 2 is open");
		producer.sendToChannelThree("Channel 3 is open");
		producer.sendToChannelFour("Channel 4 is open");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("RabbitMQ Producer started. Type messages to send (type 'exit' to quit):");

		while (true) {
			System.out.println("Enter transfer size ");
			String line = reader.readLine();

			if ("exit".equalsIgnoreCase(line)) {
				System.out.println("Exiting...");
				break;
			}

			if(Integer.parseInt(line)<=2){
				producer.sendToChannelOne(line);
			}else if(Integer.parseInt(line)<=5){
				producer.sendToChannelTwo(line);
			}else if(Integer.parseInt(line)<=7){
				producer.sendToChannelThree(line);
			}else{
				producer.sendToChannelFour(line);
			}
		}

	}
}
