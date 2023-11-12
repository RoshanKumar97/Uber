package com.roshan.uber.controllers;

import com.roshan.uber.dtos.DriverDto;
import com.roshan.uber.services.DriverService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("add")
    public ResponseEntity<DriverDto> addDriver(@RequestBody DriverDto driverDto){
        return ResponseEntity.ok(driverService.addDriver(driverDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<DriverDto> getDriver(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Driver Id Cannot be -ve")
            UUID id){
        return ResponseEntity.ok(driverService.getDriver(id));
    }

    @GetMapping("list")
    public ResponseEntity<List<DriverDto>> listDrivers(){
        return ResponseEntity.ok(driverService.listDrivers());
    }
}
