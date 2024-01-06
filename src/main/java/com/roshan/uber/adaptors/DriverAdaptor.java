package com.roshan.uber.adaptors;

import com.roshan.uber.dtos.DriverDto;
import com.roshan.uber.dtos.RiderDto;
import com.roshan.uber.models.DriverEntity;
import com.roshan.uber.models.RiderEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DriverAdaptor {
    public static DriverDto toDto(DriverEntity driverEntity){
        return DriverDto.builder()
                .id(driverEntity.getId())
                .name(driverEntity.getName())
                .email(driverEntity.getEmail())
                .password(driverEntity.getPassword())
                .mobile(driverEntity.getMobile())
                .driverStatus(driverEntity.getDriverStatus())
                .carDto(CarAdaptor.toDto(driverEntity.getCarEntity()))
                .build();
    }
    public static DriverEntity toEntity(DriverDto driverDto){
        return DriverEntity.builder()
                .id(driverDto.getId())
                .name(driverDto.getName())
                .email(driverDto.getEmail())
                .password(driverDto.getPassword())
                .mobile(driverDto.getMobile())
                .driverStatus(driverDto.getDriverStatus())
                .carEntity(CarAdaptor.toEntity(driverDto.getCarDto()))
                .build();
    }

    public static List<DriverDto> toDtos(List<DriverEntity> driverEntities) {
        List<DriverDto> driverDtos = new ArrayList<>();
        for (DriverEntity driverEntity: driverEntities) {
            driverDtos.add(DriverDto.builder()
                    .id(driverEntity.getId())
                    .name(driverEntity.getName())
                    .email(driverEntity.getEmail())
                    .password(driverEntity.getPassword())
                    .mobile(driverEntity.getMobile())
                    .build());
        }
        return driverDtos;
    }
}
