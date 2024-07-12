package com.alura.forohub.controller;

import com.alura.forohub.model.users.LoginDto;
import com.alura.forohub.infra.security.AuthenticationService;
import com.alura.forohub.infra.security.JwtTokenService;
import com.alura.forohub.infra.security.JWTTokenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController

public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationService authService;



    @PostMapping("/login")
    public ResponseEntity<JWTTokenData> login (@RequestBody LoginDto loginData) {
        String token = authService.login(loginData);

        JWTTokenData jwtAuthResponse = new JWTTokenData();
        jwtAuthResponse.setJwtToken(token);

        return ResponseEntity.ok(jwtAuthResponse);

    }


  
}
