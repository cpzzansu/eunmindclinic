package org.teamhub.groupware.admin.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.admin.payload.FindMemberDto;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.mapper.MemberMapper;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class AdminMemberService {

    private final MemberRepository memberRepository;
    private EmailService emailService;
    private PasswordEncoder passwordEncoder;

    public List<MemberDto> getMemberList() {

        List<Member> members = memberRepository.findAll();

        List<MemberDto> memberDtos = new ArrayList<>();

        for(Member member : members){
            MemberDto memberDto = MemberMapper.toDto(member);
            memberDtos.add(memberDto);
        }

        return memberDtos;
    }

    public void memberRoleChange(MemberDto memberDto) {

        Long id = memberDto.getId();

        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isPresent()){
            Member member = optionalMember.get();

            member.changeRole(memberDto);
        }
    }

    public void memberDelete(Long id) {
        memberRepository.deleteById(id);
    }

    public void sendVerificationCode(FindMemberDto findMemberDto){

        String title = "은헌정 정신건강의학과의원 관리자 페이지 계정 비밀번호 찾기 인증번호 입니다.";
        String text = "인증번호 : " + findMemberDto.getVerificationCode();

        emailService.sendSimpleMessage(findMemberDto.getEmail(), title, text);
    }

    public FindMemberDto findPassword(MemberDto memberDto) {
        String result = "";
        String username = memberDto.getUsername();
        Optional<MemberDto> optionalMemberDto = memberRepository.findByUsername(username);
        FindMemberDto findMemberDto = new FindMemberDto();
        if(optionalMemberDto.isPresent()){
            log.info("아이디가 존재해요");
            String email = memberDto.getEmail();
            if(optionalMemberDto.get().getEmail().equals(email)){
                findMemberDto.setMessage("3");
                Random random = new Random();
                int randomNumber = random.nextInt(900000) + 100000;
                findMemberDto.setVerificationCode(String.valueOf(randomNumber));
            }else {
                findMemberDto.setMessage("2");
            }
        }else{
            findMemberDto.setMessage("1");
        }
        return findMemberDto;
    }

    public void changePassword(MemberDto memberDto) {

        String password = memberDto.getPassword();

        String username = memberDto.getUsername();

        memberDto.setPassword(passwordEncoder.encode(password));

        Optional<MemberDto> optionalMemberDto = memberRepository.findByUsername(username);

        if(optionalMemberDto.isPresent()){
            Long id = optionalMemberDto.get().getId();

            Optional<Member> optionalMember = memberRepository.findById(id);

            if(optionalMember.isPresent()){
                Member member = optionalMember.get();
                member.changePassword(memberDto);
            }
        }
    }

    public MemberDto getMember(String username) {

        Optional<MemberDto> optionalMemberDto = memberRepository.findByUsername(username);
        MemberDto memberDto = null;
        if(optionalMemberDto.isPresent()){
            memberDto = optionalMemberDto.get();
        }
        return memberDto;
    }
}
