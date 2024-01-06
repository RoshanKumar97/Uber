package com.roshan.uber.controllers;

import com.roshan.uber.dtos.RiderDto;
import com.roshan.uber.services.RiderService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.roshan.uber.constants.ApplicationConstants.ADD;
import static com.roshan.uber.constants.ApplicationConstants.LIST;

@RestController
@RequestMapping("rider")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @PostMapping(ADD)
    public ResponseEntity<RiderDto> addRider(@RequestBody RiderDto riderDto){
        return ResponseEntity.ok(riderService.addRider(riderDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<RiderDto> getRider(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Rider Id Cannot be -ve")
            UUID id){
        return ResponseEntity.ok(riderService.getRider(id));
    }

    @GetMapping(LIST)
    public ResponseEntity<List<RiderDto>> listRiders(){
        return ResponseEntity.ok(riderService.listRiders());
    }
}
