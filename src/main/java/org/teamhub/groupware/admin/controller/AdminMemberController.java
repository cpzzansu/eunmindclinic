package org.teamhub.groupware.admin.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.teamhub.groupware.admin.service.AdminMemberService;
import org.teamhub.groupware.common.payload.MemberDto;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    @GetMapping("/getMemberList")
    public List<MemberDto> getMemberList(){
        return adminMemberService.getMemberList();
    }

    @PostMapping("/memberRoleChange")
    public void memberRoleChange(@RequestBody MemberDto memberDto){
        adminMemberService.memberRoleChange(memberDto);
    }
}
