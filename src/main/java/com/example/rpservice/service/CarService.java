package com.example.rpservice.service;

import com.example.rpservice.model.Car;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @KafkaListener(topics = "second", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "second_json", groupId = "group_car", containerFactory = "carKafkaListenerContainerFactory")
    public void consumeCar(Car car){
        System.out.println("Consumed Car: " + car.toString());
    }
}