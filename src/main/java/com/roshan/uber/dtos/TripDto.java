package com.roshan.uber.dtos;

import com.roshan.uber.utils.geocode.Response;
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
    private Response pickup;
    private Response destination;
}
