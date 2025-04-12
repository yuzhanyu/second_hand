package com.secondhand1.config;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

/**
 * @author hanghang
 * @date 2025/3/21
 * @Description
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private long expirationTime;
    private Key secretKey;

    public JwtConfig() {
        // 使用Keys类生成一个符合HS512要求的密钥
        this.secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
    }

    public Key getSecret() {
        return secretKey;
    }

    // Getters and Setters

    public void setSecret(String secret) {
        this.secretKey = secretKey;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
