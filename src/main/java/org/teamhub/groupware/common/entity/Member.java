package org.teamhub.groupware.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "TB_MEMBERS")
public class Member {

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;

    @Column(name = "GROUP_ID", nullable = true, length = 20)
    private String groupId;

    @Column(name = "REF_ID", nullable = true, length = 20)
    private String refId;

    @Column(name = "COUNTRY", nullable = true, length = 200)
    private String country;

    @Column(name = "PASSWD", nullable = true, length = 1000)
    private String password;

    @Column(name = "PASSWD_IO", nullable = true, length = 1000)
    private String passwordIO;

    @Column(name = "COMPANY", nullable = true, length = 200)
    private String company;

    @Column(name = "NAME", nullable = true, length = 45)
    private String name;

    @Column(name = "EMAIL", nullable = true, length = 100)
    private String email;

    @Column(name = "TEL", nullable = true, length = 45)
    private String tel;

    @Column(name = "HP", nullable = true, length = 45)
    private String hp;

    @Column(name = "LEVEL", nullable = true)
    private int level;

    @Column(name = "STATUS", nullable = true)
    private int status;

    @Column(name = "RDATE", nullable = true)
    private LocalDateTime rdate;

    @Column(name = "LDATE", nullable = true)
    private LocalDateTime ldate;


}
