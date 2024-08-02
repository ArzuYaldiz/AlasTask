package com.example.liquibase.Service;

import com.example.liquibase.Entity.User;
import com.example.liquibase.RequestResponseDto.AuthenticationRequestDto;
import com.example.liquibase.RequestResponseDto.AuthenticationResponseDto;
import com.example.liquibase.RequestResponseDto.RegisterRequestDto;

public interface AuthenticationService {

    User register(RegisterRequestDto request);

    User redisCreateUser(User user);

    User login(AuthenticationRequestDto request);

    User redisGetUser(User user);

    AuthenticationResponseDto createToken(User user);

    void revokeAllUserTokens(User user);

    void savedUserToken(User user, String jwtToken);
}