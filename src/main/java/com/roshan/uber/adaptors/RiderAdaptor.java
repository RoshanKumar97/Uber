package com.roshan.uber.adaptors;

import com.roshan.uber.dtos.RiderDto;
import com.roshan.uber.models.RiderEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class RiderAdaptor {
    public static RiderDto toDto(RiderEntity riderEntity){
        return RiderDto.builder()
                .id(riderEntity.getId())
                .name(riderEntity.getName())
                .email(riderEntity.getEmail())
                .password(riderEntity.getPassword())
                .mobile(riderEntity.getMobile())
                .tripDtos(TripAdaptor.toDtos(riderEntity.getTripEntities()))
                .build();
    }

    public static RiderEntity toEntity(RiderDto riderDto){
        return RiderEntity.builder()
                .id(riderDto.getId())
                .name(riderDto.getName())
                .email(riderDto.getEmail())
                .password(riderDto.getPassword())
                .mobile(riderDto.getMobile())
                .tripEntities(TripAdaptor.toEntity(riderDto.getTripDtos()))
                .build();
    }

    public static List<RiderDto> toDtos(List<RiderEntity> riderEntities) {
        List<RiderDto> riderDtos = new ArrayList<>();
        for (RiderEntity riderEntity: riderEntities) {
            riderDtos.add(RiderDto.builder()
                    .id(riderEntity.getId())
                    .name(riderEntity.getName())
                    .email(riderEntity.getEmail())
                    .password(riderEntity.getPassword())
                    .mobile(riderEntity.getMobile())
                    .tripDtos(TripAdaptor.toDtos(riderEntity.getTripEntities()))
                    .build());
        }
        return riderDtos;
    }
}
