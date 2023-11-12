package com.roshan.uber.services.impls;

import com.roshan.uber.services.GeoCoderService;
import com.roshan.uber.utils.geocode.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class GeoCoderServiceImpl implements GeoCoderService {
    private static final Object API_KEY = null;
    @Override
    public Response getGeoDetails(String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .queryParam("key", API_KEY)
                .queryParam("address", address)
                .build();

        ResponseEntity<Response> response = new RestTemplate().getForEntity(uri.toUriString(), Response.class);

        return response.getBody();

    }
}
