package com.roshan.uber.utils.jwt;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationRequest {
    private String mobile;
    private String password;
}
