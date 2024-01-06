package com.roshan.uber.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class RiderDto {
    private UUID id;

    @NotBlank(message = "Rider name is mandatory")
    private String name;

    @NotBlank(message = "Rider email is mandatory")
    private  String email;

    @NotBlank(message = "Rider password is mandatory")
    private String password;

    @NotBlank(message = "Rider mobile is mandatory")
    private String mobile;

}
