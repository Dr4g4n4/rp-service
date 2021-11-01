package com.example.rrservice.service;

import com.example.rrservice.model.EngineType;
import com.example.rrservice.repository.CarRepository;
import com.example.rrservice.model.Car;
import com.example.rrservice.repository.EngineTypeRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carrepository;
    private EngineTypeRepository engintyperepository;
    @Autowired
    public CarService(CarRepository carrepository,EngineTypeRepository engintyperepository) {
        this.carrepository = carrepository;
        this.engintyperepository=engintyperepository;
    }

    @KafkaListener(topics = "second", groupId = "group_id")
    public void consume(Car car) {
        System.out.println("Consumed message: " + car.toString());
        save(car);
    }

    public void save(Car car){
        org.springframework.data.domain.Example<EngineType> motor = org.springframework.data.domain.Example.of(car.getEngineType());
     //   if(!engintyperepository.exists(motor)){
            engintyperepository.save(car.getEngineType());
       // }

        carrepository.save(car);
    }
  /*  @KafkaListener(topics = "second_json", groupId = "group_car", containerFactory = "carKafkaListenerContainerFactory")
    public void consumeCar(Car car){
        System.out.println("Consumed Car: " + car.toString());
    }*/
}