package com.example.liquibase.Service.ımpl;

import com.example.liquibase.Entity.Role;
import com.example.liquibase.Repository.UserRepository;
import com.example.liquibase.RequestResponseDto.AuthenticationRequestDto;
import com.example.liquibase.RequestResponseDto.AuthenticationResponseDto;
import com.example.liquibase.RequestResponseDto.RegisterRequestDto;
import com.example.liquibase.Service.AuthenticationService;
import com.example.liquibase.Service.JWTService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.example.liquibase.Entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationImpl implements AuthenticationService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JWTService jwtService;
    AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDto register(RegisterRequestDto request) {
        var user = User.builder()
                .user_name(request.getUser_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }
}
