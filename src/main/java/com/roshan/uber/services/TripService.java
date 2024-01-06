package com.roshan.uber.services;

import com.roshan.uber.dtos.TripDto;

import java.util.List;
import java.util.UUID;


public interface TripService {

    List<TripDto> listTrips();
    TripDto getTrip(UUID id);
    TripDto addTrip(TripDto tripDto);
}
