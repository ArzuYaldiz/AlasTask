package com.example.liquibase.Controller;

import com.example.liquibase.Entity.User;
import com.example.liquibase.RequestResponseDto.AuthenticationRequestDto;
import com.example.liquibase.RequestResponseDto.AuthenticationResponseDto;
import com.example.liquibase.RequestResponseDto.RegisterRequestDto;
import com.example.liquibase.Service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api/auth")
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto request) {
        User user = authenticationService.register(request);
        authenticationService.redisCreateUser(user);
        return ResponseEntity.ok(authenticationService.createToken(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto request) {
        User user = authenticationService.login(request);
        authenticationService.redisGetUser(user);
        return ResponseEntity.ok(authenticationService.createToken(user));
    }

}
