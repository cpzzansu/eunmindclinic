package org.teamhub.groupware.admin.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.mapper.MemberMapper;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class AdminMemberService {

    private final MemberRepository memberRepository;

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
}
