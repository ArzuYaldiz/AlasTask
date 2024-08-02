package com.example.liquibase.Service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JWTService {

    String extractUserEmail(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    Claims extractALLClaims(String token);

    Key getSignInKey();

    String generateToken(UserDetails userDetails);

    String generateTokenMultiple(Map<String, Object> extraClaims, UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);
}
