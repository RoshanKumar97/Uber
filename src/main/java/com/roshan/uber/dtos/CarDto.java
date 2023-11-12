package com.roshan.uber.dtos;

import com.roshan.uber.enums.CarType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class CarDto {
    private UUID id;

    @NotBlank(message = "Car Registration Number is mandatory")
    private String RegistrationNumber;

    @NotBlank(message = "Car model is mandatory")
    private String model;

    @NotBlank(message = "Car Type is mandatory")
    private CarType carType;

    private DriverDto driverDto;
}
