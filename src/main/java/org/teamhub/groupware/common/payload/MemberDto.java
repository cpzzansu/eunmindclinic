package org.teamhub.groupware.common.payload;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.teamhub.groupware.common.entity.Role;
import org.teamhub.groupware.common.entity.Status;

import java.time.LocalDateTime;

@Data
@Builder
public class MemberDto {

    @NotBlank
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String name;
    @NotEmpty
    private String email;
    private String tel;
    private String hp;
    private Role role;
    private Status status;
    private String createdBy;
    private String department;
    private String position;
    private LocalDateTime rdate;
    private LocalDateTime ldate;

    @QueryProjection
    public MemberDto(Long id, String username, String password, String name, String email, String tel, String hp, Role role, Status status, String createdBy, String department, String position, LocalDateTime rdate, LocalDateTime ldate) {
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
        this.department = department;
        this.position = position;
        this.rdate = rdate;
        this.ldate = ldate;
    }
}
