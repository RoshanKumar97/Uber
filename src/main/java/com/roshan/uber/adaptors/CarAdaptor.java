package com.roshan.uber.adaptors;

import com.roshan.uber.dtos.CarDto;
import com.roshan.uber.models.CarEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarAdaptor {

    public static CarDto toDto(CarEntity carEntity){
        return CarDto.builder()
                .id(carEntity.getId())
                .model(carEntity.getModel())
                .carType(carEntity.getCarType())
                .RegistrationNumber(carEntity.getRegistrationNumber())
                .driverDto(DriverAdaptor.toDto(carEntity.getDriverEntity()))
                .build();
    }

    public static CarEntity toEntity(CarDto carDto){
        return CarEntity.builder()
                .id(carDto.getId())
                .model(carDto.getModel())
                .carType(carDto.getCarType())
                .RegistrationNumber(carDto.getRegistrationNumber())
                .driverEntity(DriverAdaptor.toEntity(carDto.getDriverDto()))
                .build();
    }
}
