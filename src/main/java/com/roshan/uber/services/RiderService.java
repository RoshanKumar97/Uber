package com.roshan.uber.services;

import com.roshan.uber.dtos.RiderDto;

import java.util.List;
import java.util.UUID;

public interface RiderService {
    List<RiderDto> listRiders();
    RiderDto getRider(UUID id);
    RiderDto addRider(RiderDto riderDto);

    RiderDto getRiderByMobile(String email);
}
