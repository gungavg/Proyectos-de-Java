package com.example.proyecto3.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtils {
    private final String secretKey = "";
    public Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }
    public boolean isExpired(String token){
        try{
            return getClaims(token).getExpiration().before(new Date());
        }catch(Exception e){
            return true;
        }
    }

    public Integer extractUserId(String token){
        try{
            return Integer.parseInt(getClaims(token).getSubject());

        }catch(Exception e){
            return null;
        }
    }
}
