package com.roshan.uber.controllers;

import com.roshan.uber.services.impls.RiderDetailsServiceImpl;
import com.roshan.uber.utils.jwt.AuthenticationRequest;
import com.roshan.uber.utils.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import static com.roshan.uber.constants.ApplicationConstants.*;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(LOGIN)
@RestController
public class LoginController {
    @Autowired
    RiderDetailsServiceImpl userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping(AUTHENTICATE)
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthenticationRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getMobile(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return ResponseEntity.ok(jwtUtil.generateToken(authRequest.getMobile()));
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
