package com.roshan.uber.dtos;

import com.roshan.uber.enums.DriverStatus;
import com.roshan.uber.services.DriverService;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class DriverDto {
    private UUID id;

    @NotBlank(message = "Driver name is mandatory")
    private String name;

    @NotBlank(message = "Driver email is mandatory")
    private  String email;

    @NotBlank(message = "Driver password is mandatory")
    private String password;

    @NotBlank(message = "Driver mobile is mandatory")
    private String mobile;

    List<TripDto> tripDtos;

    CarDto carDto;

    DriverStatus driverStatus;
}
