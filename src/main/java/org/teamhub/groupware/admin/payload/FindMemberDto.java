package org.teamhub.groupware.admin.payload;

import lombok.Data;

@Data
public class FindMemberDto {
    private String message;
    private String verificationCode;
    private String email;
}
