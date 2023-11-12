package com.roshan.uber.adaptors;

import com.roshan.uber.dtos.TripDto;
import com.roshan.uber.models.TripEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TripAdaptor {
    public static TripDto toDto(TripEntity tripEntity){
        return TripDto.builder()
                .id(tripEntity.getId())
                .pickup(tripEntity.getPickup())
                .destination(tripEntity.getDestination())
                .driverDto(DriverAdaptor.toDto(tripEntity.getDriverEntity()))
                .riderDto(RiderAdaptor.toDto(tripEntity.getRiderEntity()))
                .build();
    }
    public static List<TripDto> toDtos(List<TripEntity> tripEntities){
        List<TripDto> tripDtos = new ArrayList<>();
        for (TripEntity tripEntity: tripEntities) {
            tripDtos.add(TripDto.builder()
                    .id(tripEntity.getId())
                    .pickup(tripEntity.getPickup())
                    .destination(tripEntity.getDestination())
                    .driverDto(DriverAdaptor.toDto(tripEntity.getDriverEntity()))
                    .riderDto(RiderAdaptor.toDto(tripEntity.getRiderEntity()))
                    .build());
        }
        return tripDtos;
    }

    public static TripEntity toEntity(TripDto tripDto){
        return TripEntity.builder()
                .id(tripDto.getId())
                .pickup(tripDto.getPickup())
                .destination(tripDto.getDestination())
                .driverEntity(DriverAdaptor.toEntity(tripDto.getDriverDto()))
                .riderEntity(RiderAdaptor.toEntity(tripDto.getRiderDto()))
                .build();
    }
    public static List<TripEntity> toEntity (List<TripDto> tripDtos){
        List<TripEntity> tripEntities = new ArrayList<>();
        for (TripDto tripDto: tripDtos) {
            tripEntities.add(TripEntity.builder()
                    .id(tripDto.getId())
                    .pickup(tripDto.getPickup())
                    .destination(tripDto.getDestination())
                    .driverEntity(DriverAdaptor.toEntity(tripDto.getDriverDto()))
                    .riderEntity(RiderAdaptor.toEntity(tripDto.getRiderDto()))
                    .build());
        }
        return tripEntities;
    }
}
