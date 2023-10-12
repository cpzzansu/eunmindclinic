package org.teamhub.groupware.common.mapper;


import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.payload.MemberDto;

public class MemberMapper {

    public static MemberDto toDto(Member member) {
        MemberDto.MemberDtoBuilder builder = MemberDto.builder()
                .id(member.getId())
                .groupId(member.getGroupId())
                .refId(member.getRefId())
                .country(member.getCountry())
                .password(member.getPassword())
                .passwordIO(member.getPasswordIO())
                .company(member.getCompany())
                .name(member.getName())
                .email(member.getEmail())
                .tel(member.getTel())
                .hp(member.getHp())
                .level(member.getLevel())
                .status(member.getStatus())
                .rdate(member.getRdate())
                .ldate(member.getLdate());

        return builder.build();
    }


    public static Member toEntity(MemberDto memberDto) {
        Member.MemberBuilder builder = Member.builder()
                .id(memberDto.getId())
                .groupId(memberDto.getGroupId())
                .refId(memberDto.getRefId())
                .country(memberDto.getCountry())
                .password(memberDto.getPassword())
                .passwordIO(memberDto.getPasswordIO())
                .company(memberDto.getCompany())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .tel(memberDto.getTel())
                .hp(memberDto.getHp())
                .level(memberDto.getLevel())
                .status(memberDto.getStatus())
                .rdate(memberDto.getRdate())
                .ldate(memberDto.getLdate());

        return builder.build();
    }
}
