package org.teamhub.groupware.common.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamhub.groupware.common.payload.JWTAuthResponse;
import org.teamhub.groupware.common.payload.LoginDto;
import org.teamhub.groupware.common.service.AuthService;

import java.util.Arrays;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final long COOKIE_EXPIRATION = 7776000;

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> login(@Valid @RequestBody LoginDto loginDto, HttpServletResponse response) {
        try {
            JWTAuthResponse jwtResponse = authService.login(loginDto);

            Cookie accessTokenCookie = new Cookie("accessToken", jwtResponse.getAccessToken());
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setMaxAge(7 * 24 * 60 * 60);
//            accessTokenCookie.setSecure(true);

            Cookie refreshTokenCookie = new Cookie("refreshToken", jwtResponse.getRefreshToken());
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setPath("/");
            refreshTokenCookie.setMaxAge(7 * 24 * 60 * 60);
//            refreshTokenCookie.setSecure(true);

            response.addCookie(accessTokenCookie);
            response.addCookie(refreshTokenCookie);

            return ResponseEntity.ok(jwtResponse);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String refreshToken = Arrays.stream(cookies)
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (refreshToken != null) {
            authService.logout(refreshToken);
        }

        Cookie invalidateAccessToken = new Cookie("accessToken", null);
        invalidateAccessToken.setMaxAge(0);
        invalidateAccessToken.setHttpOnly(true);

        Cookie invalidateRefreshToken = new Cookie("refreshToken", null);
        invalidateRefreshToken.setMaxAge(0);
        invalidateRefreshToken.setHttpOnly(true);

        return ResponseEntity.noContent()
                .header(HttpHeaders.SET_COOKIE, invalidateAccessToken.toString())
                .header(HttpHeaders.SET_COOKIE, invalidateRefreshToken.toString())
                .build();
    }


    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String refreshToken = Arrays.stream(cookies)
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (refreshToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No refresh token provided");
        }

        try {
            JWTAuthResponse jwtResponse = authService.refreshToken(refreshToken);

            Cookie accessTokenCookie = new Cookie("accessToken", jwtResponse.getAccessToken());
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setMaxAge(7 * 24 * 60 * 60);
//            accessTokenCookie.setSecure(true);

            Cookie newRefreshTokenCookie = new Cookie("refreshToken", jwtResponse.getRefreshToken());
            newRefreshTokenCookie.setHttpOnly(true);
            newRefreshTokenCookie.setPath("/");
            newRefreshTokenCookie.setMaxAge(30 * 24 * 60 * 60);  // for example: 1 month
//            newRefreshTokenCookie.setSecure(true);

            ResponseEntity.BodyBuilder response = ResponseEntity.ok();
            response.header(HttpHeaders.SET_COOKIE, accessTokenCookie.toString());
            response.header(HttpHeaders.SET_COOKIE, newRefreshTokenCookie.toString());

            return response.body(jwtResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


}

