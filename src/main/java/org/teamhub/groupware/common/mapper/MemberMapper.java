package org.teamhub.groupware.common.mapper;


import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.payload.MemberDto;

public class MemberMapper {

    public static MemberDto toDto(Member member) {
        MemberDto.MemberDtoBuilder builder = MemberDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .password(member.getPassword())
                .name(member.getName())
                .email(member.getEmail())
                .tel(member.getTel())
                .hp(member.getHp())
                .role(member.getRole())
                .status(member.getStatus())
                .createdBy(member.getCreatedBy())
                .rdate(member.getRdate())
                .ldate(member.getLdate());

        return builder.build();
    }


    public static Member toEntity(MemberDto memberDto) {
        Member.MemberBuilder builder = Member.builder()
                .id(memberDto.getId())
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .tel(memberDto.getTel())
                .hp(memberDto.getHp())
                .role(memberDto.getRole())
                .status(memberDto.getStatus())
                .createdBy(memberDto.getCreatedBy())
                .rdate(memberDto.getRdate())
                .ldate(memberDto.getLdate());

        return builder.build();
    }
}
