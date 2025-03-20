package com.mango.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
public class JwtUtils {
    private static final String SECRET_KEY = "J7/rzIj81yJWcCtI9iJ1B8WtigthgNlwV2VFea+hi10=";
    private static final long EXPIRATION_TIME = 86400000;

    public static String generateToken(String userId, String role) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("role", role) // 自定义 Claim（如用户角色）
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
