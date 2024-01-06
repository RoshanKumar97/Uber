package com.roshan.uber.utils.jwt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AuthenticationResponse {
    private final String jwt;
}
