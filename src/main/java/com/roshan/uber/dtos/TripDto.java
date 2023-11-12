package com.roshan.uber.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TripDto {
    private UUID id;
    private DriverDto driverDto;
    private RiderDto riderDto;
    private String pickup;
    private String destination;
}
