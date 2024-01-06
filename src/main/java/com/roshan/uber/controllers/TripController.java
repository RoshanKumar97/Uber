package com.roshan.uber.controllers;

import com.roshan.uber.dtos.TripDto;
import com.roshan.uber.services.TripService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("add")
    public ResponseEntity<TripDto> addTrip(@RequestBody TripDto tripDto){
        return ResponseEntity.ok(tripService.addTrip(tripDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<TripDto> getTrip(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Trip Id Cannot be -ve")
            UUID id){
        return ResponseEntity.ok(tripService.getTrip(id));
    }

    @GetMapping("list")
    public ResponseEntity<List<TripDto>> listTrips(){
        return ResponseEntity.ok(tripService.listTrips());
    }
}
