package com.roshan.uber.services;

import com.roshan.uber.dtos.DriverDto;

import java.util.List;
import java.util.UUID;

public interface DriverService {

    List<DriverDto> listDrivers();
    DriverDto getDriver(UUID id);
    DriverDto addDriver(DriverDto driverDto);

    DriverDto getDriverByMobile(String mobile);
}
