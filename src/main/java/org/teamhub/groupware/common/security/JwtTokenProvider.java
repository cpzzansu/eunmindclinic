package org.teamhub.groupware.common.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.teamhub.groupware.common.entity.RefreshToken;
import org.teamhub.groupware.common.exception.APIException;
import org.teamhub.groupware.common.repository.RefreshTokenRepository;

import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public String generateRefreshToken(String id) {
        String refreshToken = UUID.randomUUID().toString().replace("-", "");

        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + jwtExpirationDate); // adjust as needed

        RefreshToken token = new RefreshToken(refreshToken, id, expiryDate);
        try {
            refreshTokenRepository.save(token);
            // Log for successful save:
            log.info("Token was saved successfully: " + token.getToken());
        } catch (Exception e) {
            // It's better to use the logger to see the exception
            log.error("Error while saving token", e);
        }

        // Check if token is saved successfully
        boolean exists = refreshTokenRepository.existsById(token.getToken());
        if (!exists) {
            log.error("Token was not saved: " + token.getToken());
        }

        return refreshToken;
    }

    public boolean validateRefreshToken(String token) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByToken(token);

        if (refreshToken.isPresent()) {
            if (refreshToken.get().getExpiryDate().before(new Date())) {
                refreshTokenRepository.deleteByToken(token);
                return false;
            }

            return true;
        }

        return false;
    }

    // generate JWT token
    public String generateToken(Authentication authentication) {
        String id = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return token;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    // get username from Jwt token
    public String getId(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String id = claims.getSubject();

        return id;
    }

    // validate Jwt token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Invaild JWT token");
        } catch (ExpiredJwtException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "JWT claims string is empty");
        }
    }
}