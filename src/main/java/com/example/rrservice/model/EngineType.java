package com.example.rrservice.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ENGINE_TYPE")
public class EngineType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "motor_power")
    private int motorPower;

    @Column(name = "h_power")
    private int hPower;

    @Column(name = "volume")
    private int volume;

    @Column(name = "number_of_cylinders")
    private int numberOfCylinders;

    @Column(name = "primary_fuel")
    private String primaryFuel;

    @JsonManagedReference(value = "engine_mov")
    @OneToMany(mappedBy = "engineType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<Car>();

    public EngineType() {
    }

    public EngineType(Long id, int motorPower, int hPower, int volume, int numberOfCylinders, String primaryFuel, Set<Car> cars) {
        this.id = id;
        this.motorPower = motorPower;
        this.hPower = hPower;
        this.volume = volume;
        this.numberOfCylinders = numberOfCylinders;
        this.primaryFuel = primaryFuel;
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "EngineType{" +
                "id=" + id +
                ", motorPower=" + motorPower +
                ", hPower=" + hPower +
                ", volume=" + volume +
                ", numberOfCylinders=" + numberOfCylinders +
                ", primaryFuel='" + primaryFuel + '\'' +
                '}';
    }
}