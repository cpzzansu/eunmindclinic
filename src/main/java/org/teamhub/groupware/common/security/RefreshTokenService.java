package org.teamhub.groupware.common.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.common.payload.JWTAuthResponse;
import org.teamhub.groupware.common.repository.RefreshTokenRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public JWTAuthResponse refresh(String refreshToken) {
        if (jwtTokenProvider.validateRefreshToken(refreshToken)) {
            String username = refreshTokenRepository.findByToken(refreshToken).get().getUsername();
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());

            String newAccessToken = jwtTokenProvider.generateToken(authentication);
            String newRefreshToken = jwtTokenProvider.generateRefreshToken(username);

            refreshTokenRepository.deleteByToken(refreshToken);

            return new JWTAuthResponse(newAccessToken, newRefreshToken, "Bearer");
        } else {
            throw new RuntimeException("Invalid refresh token");
        }
    }
}
