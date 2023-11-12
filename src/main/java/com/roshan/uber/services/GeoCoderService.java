package com.roshan.uber.services;

import com.roshan.uber.utils.geocode.Response;

public interface GeoCoderService {
    Response getGeoDetails(String address);
}
