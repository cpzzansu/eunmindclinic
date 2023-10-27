package org.teamhub.groupware.admin.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.teamhub.groupware.admin.service.MemberService;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.payload.MemberDto;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/adminAddMember")
    public void addMember(@RequestBody MemberDto memberDto){
        memberService.addMember(memberDto);
    }
}
