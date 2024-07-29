package com.example.liquibase.Service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JWTService {

    public String extractUserEmail(String token);

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    public Claims extractALLClaims(String token);

    public Key getSignInKey();

    public String generateToken(UserDetails userDetails);

    public String generateTokenMultiple(Map<String, Object> extraClaims, UserDetails userDetails);

    public boolean isTokenValid(String token, UserDetails userDetails);

    public boolean isTokenExpired(String token);

    public Date extractExpiration(String token);
}
