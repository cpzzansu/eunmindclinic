package org.teamhub.groupware.common.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.exception.ResourceNotFoundException;
import org.teamhub.groupware.common.mapper.MemberMapper;
import org.teamhub.groupware.common.payload.JWTAuthResponse;
import org.teamhub.groupware.common.payload.LoginDto;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.repository.MemberRepository;
import org.teamhub.groupware.common.security.JwtTokenProvider;
import org.teamhub.groupware.common.service.AuthService;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, String> redisTemplate;
    private final UserDetailsService userDetailsService;

    @Value("${app.refresh-token-expiration-milliseconds}")
    private long refreshTokenExpirationDate;

    @Override
    public JWTAuthResponse login(LoginDto loginDto) {
        log.info("loginDto : {}", loginDto.getPassword());
        String input = loginDto.getIdOrEmail();
        log.info("input: {}", input);
        MemberDto authenticationEntity = memberRepository.findByIdAndEmail(input, input)
                .orElseThrow(() -> new ResourceNotFoundException("MemberDto", "IdAndEmail", input));

        Member authReq = MemberMapper.toEntity(MemberDto.builder()
                .id(authenticationEntity.getId())
                .password(loginDto.getPassword())
                .build());
        try {
            Authentication authResult = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authReq.getId(),
                            authReq.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authResult);
            String jwt = jwtTokenProvider.generateToken(authResult);
            String refreshToken = UUID.randomUUID().toString().replace("-", "");
            redisTemplate.opsForValue().set(refreshToken, authReq.getId());
            redisTemplate.expire(refreshToken, refreshTokenExpirationDate, TimeUnit.MILLISECONDS);
            return new JWTAuthResponse(jwt, "Bearer", refreshToken);
        } catch (Exception e) {
            log.error("Error during authentication: ", e);
            throw e;
        }
    }

        @Override
        public void logout (String refreshToken){
            redisTemplate.delete(refreshToken);
        }

        @Override
        public JWTAuthResponse refreshToken (String refreshToken){
            if (refreshToken == null || refreshToken.trim().isEmpty()) {
                throw new IllegalArgumentException("Refresh token is missing.");
            }

            String username = redisTemplate.opsForValue().get(refreshToken);
            if (username == null) {
                throw new IllegalArgumentException("Invalid or expired refresh token.");
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            String jwt = jwtTokenProvider.generateToken(authentication);
            String newRefreshToken = UUID.randomUUID().toString().replace("-", "");
            redisTemplate.opsForValue().set(newRefreshToken, username);
            redisTemplate.expire(newRefreshToken, refreshTokenExpirationDate, TimeUnit.MILLISECONDS);
            redisTemplate.delete(refreshToken);
            return new JWTAuthResponse(jwt, "Bearer", newRefreshToken);
        }
    }