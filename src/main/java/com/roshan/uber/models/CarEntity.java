package com.roshan.uber.models;

import com.roshan.uber.enums.CarType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cars")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class CarEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(name = "registration_number", nullable = false)
    private String RegistrationNumber;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "type", nullable = false)
    private CarType carType;

    @OneToOne
    private DriverEntity driverEntity;

}
