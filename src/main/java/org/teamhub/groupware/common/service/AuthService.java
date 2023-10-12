package org.teamhub.groupware.common.service;


import org.teamhub.groupware.common.payload.JWTAuthResponse;
import org.teamhub.groupware.common.payload.LoginDto;

public interface AuthService {
    JWTAuthResponse login(LoginDto loginDto);
    void logout(String refreshToken);
    JWTAuthResponse refreshToken(String refreshToken);
}
