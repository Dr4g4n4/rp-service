package com.example.rrservice.repository;


import com.example.rrservice.model.Car;
import com.example.rrservice.model.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {

}
