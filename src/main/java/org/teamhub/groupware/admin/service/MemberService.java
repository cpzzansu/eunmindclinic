package org.teamhub.groupware.admin.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.mapper.MemberMapper;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.repository.MemberRepository;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;

    public void addMember(MemberDto memberDto){
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member member = MemberMapper.toEntity(memberDto);
        memberRepository.save(member);
    }
}
