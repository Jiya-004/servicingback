package com.AJS.vehicleservice.util;

import com.AJS.vehicleservice.model.Admin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private JwtUtil() {
        // Prevent instantiation
    }

    // Secret key for signing the token (use a secure and strong key in production)
    static String key = "This is my key. Some random value";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(key.getBytes());

    // Token validity duration in milliseconds (e.g., 1 hour)
    private static final long TOKEN_VALIDITY = 360000000;

    public static String generateToken(Admin admin) {
        return Jwts.builder()
                .setSubject(admin.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .addClaims(Map.of("id", admin.getId())) // Fixed: Properly closed the method
                .signWith(SECRET_KEY) // Fixed: Moved this method to the correct line
                .compact();
    }

    public static String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    private static boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }

}
