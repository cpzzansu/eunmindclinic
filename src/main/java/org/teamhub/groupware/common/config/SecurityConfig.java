package org.teamhub.groupware.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.teamhub.groupware.common.security.JwtAuthenticationEntryPoint;
import org.teamhub.groupware.common.security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] AUTH_WHITELIST = {
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };
    private static final String[] BASIC_LIST = {
            "/login",
            "/index.html",
            "/static/**",
            "/favicon.ico",
            "/assets/**",
            "/",
            "/images/**",
            "/academicActivities",
            "/medical",
            "/overseasPresent",
            "/mba",
            "/pubs",
            "/noticeBoardList",
            "/notice/**",
            "/greeting",
            "/clinicalDepartments",
            "/clinicHours",
            "/doctorProfile/**",
            "/gallery",
            "/directions",
            "/detail/**",
            "/noticeBoardDetail/**",
            "/admin",
            "/adminAddMember"
    };
    private static final String[] AUTHENTICATE_LIST = {
            "/api/auth/private",
            "/galleryAdd",
            "/getGallery",
            "/deleteGallery"
    };

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JwtAuthenticationFilter authenticationFilter;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers(AUTH_WHITELIST).permitAll()
                                .requestMatchers(BASIC_LIST).permitAll()
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers(AUTHENTICATE_LIST).authenticated()
                                .anyRequest().permitAll()

                ).exceptionHandling(exception -> exception
                        .authenticationEntryPoint(authenticationEntryPoint)
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
