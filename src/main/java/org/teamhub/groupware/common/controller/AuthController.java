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
import org.springframework.web.bind.annotation.*;
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

            response.addCookie(accessTokenCookie);

            return ResponseEntity.ok(jwtResponse);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {

        Cookie invalidateAccessToken = new Cookie("accessToken", null);
        invalidateAccessToken.setMaxAge(0);
        invalidateAccessToken.setHttpOnly(true);

        return ResponseEntity.noContent()
                .header(HttpHeaders.SET_COOKIE, invalidateAccessToken.toString())
                .build();
    }

    @GetMapping("/private")
    public void privateAuth(){

    }
}

