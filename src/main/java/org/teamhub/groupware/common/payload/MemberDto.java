package org.teamhub.groupware.common.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MemberDto {
    private String id;
    private String groupId;
    private String refId;
    private String country;
    private String password;
    private String passwordIO;
    private String company;
    private String name;
    private String email;
    private String tel;
    private String hp;
    private int level;
    private int status;
    private LocalDateTime rdate;
    private LocalDateTime ldate;

    @QueryProjection
    public MemberDto(String id, String groupId, String refId, String country, String password, String passwordIO, String company, String name, String email, String tel, String hp, int level, int status, LocalDateTime rdate, LocalDateTime ldate) {
        this.id = id;
        this.groupId = groupId;
        this.refId = refId;
        this.country = country;
        this.password = password;
        this.passwordIO = passwordIO;
        this.company = company;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.hp = hp;
        this.level = level;
        this.status = status;
        this.rdate = rdate;
        this.ldate = ldate;
    }

    @QueryProjection
    public MemberDto(String groupId) {
        this.groupId = groupId;
    }

    @QueryProjection
    public MemberDto(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
