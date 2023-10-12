package org.teamhub.groupware.common.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.repository.MemberRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String idOrEmail) throws UsernameNotFoundException {
        MemberDto memberDto = memberRepository.findByIdAndEmail(idOrEmail, idOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: " + idOrEmail));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + memberDto.getLevel()));

        return new User(
                memberDto.getId(),
                memberDto.getPassword(),
                grantedAuthorities);
    }
}