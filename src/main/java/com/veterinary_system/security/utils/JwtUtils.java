package com.veterinary_system.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private SecretKey key = Jwts.SIG.HS256.key().build();

    @Value("${jwt.expiration.time}")
    private String expirationTime;

    public String generateToken(Authentication authentication) {

        //extraer el usuario principal del objeto authentication
        UserDetails user = (UserDetails) authentication.getPrincipal();

        //extraer el email del userDetails
        String email = user.getUsername();

        //generar el tiempo de expiracion del token
        Instant currentDate = Instant.now();
        Instant expirationDate = currentDate.plus(Long.parseLong(expirationTime), ChronoUnit.MILLIS);

        //extraer los roles del user
        String roles = user.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //generar el token y retornarlo
        return Jwts
                .builder()
                .signWith(key)
                .subject(email)
                .claim("authorities", roles)
                .issuedAt(Date.from(currentDate))
                .expiration(Date.from(expirationDate))
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return true;
        } catch (JwtException exception) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
