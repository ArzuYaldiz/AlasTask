package com.example.liquibase.Service.ımpl;

import com.example.liquibase.Entity.Role;
import com.example.liquibase.Entity.Token;
import com.example.liquibase.Entity.TokenType;
import com.example.liquibase.Repository.TokenRepository;
import com.example.liquibase.Repository.UserRepository;
import com.example.liquibase.RequestResponseDto.AuthenticationRequestDto;
import com.example.liquibase.RequestResponseDto.AuthenticationResponseDto;
import com.example.liquibase.RequestResponseDto.RegisterRequestDto;
import com.example.liquibase.Service.AuthenticationService;
import com.example.liquibase.Service.JWTService;
import lombok.AccessLevel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.example.liquibase.Entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationImpl implements AuthenticationService {

    UserRepository userRepository;
    TokenRepository tokenRepository;
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
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        savedUserToken(savedUser, jwtToken);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        savedUserToken(user, jwtToken);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUser_id());
        if(validUserTokens.isEmpty()){
            return;
        }
        validUserTokens.forEach(t -> {
            t.setExpired(1);
            t.setRevoked(1);
        });
        tokenRepository.saveAll(validUserTokens);

    }

    @Override
    public void savedUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .token_type(TokenType.BEARER)
                .expired(0)
                .revoked(0)
                .build();
        tokenRepository.save(token);
    }
}
