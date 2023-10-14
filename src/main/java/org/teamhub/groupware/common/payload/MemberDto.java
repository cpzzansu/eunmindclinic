package org.teamhub.groupware.common.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import org.teamhub.groupware.common.entity.Role;
import org.teamhub.groupware.common.entity.Status;

import java.time.LocalDateTime;

@Data
@Builder
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String tel;
    private String hp;
    private Role role;
    private Status status;
    private String createdBy;
    private LocalDateTime rdate;
    private LocalDateTime ldate;

    @QueryProjection
    public MemberDto(Long id, String username, String password, String name, String email, String tel, String hp, Role role, Status status, String createdBy, LocalDateTime rdate, LocalDateTime ldate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.hp = hp;
        this.role = role;
        this.status = status;
        this.createdBy = createdBy;
        this.rdate = rdate;
        this.ldate = ldate;
    }
}
