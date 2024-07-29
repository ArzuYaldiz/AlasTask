package com.example.liquibase.Service;

import com.example.liquibase.RequestResponseDto.AuthenticationRequestDto;
import com.example.liquibase.RequestResponseDto.AuthenticationResponseDto;
import com.example.liquibase.RequestResponseDto.RegisterRequestDto;

public interface AuthenticationService {

    public AuthenticationResponseDto register(RegisterRequestDto request);

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request);
}