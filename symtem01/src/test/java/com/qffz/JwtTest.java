package com.qffz;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 11);
        claims.put("username", "qffz");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "YTgzNTk0MjY1MWFAcWZmel9ybWN4XzIwMDdfMDZfMDM=")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();

        System.out.println(jwt);
    }
    @Test
    public void testParseJwt() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jwt = "";
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(jwt)
                    .getPayload();
            System.out.println("解析成功：" + claims);
        } catch (Exception e) {
            System.out.println("解析失败：" + e.getMessage());
            System.out.println("原因：JWT 使用的是旧密钥签名，与当前生成的密钥不匹配");
        }
    }
}