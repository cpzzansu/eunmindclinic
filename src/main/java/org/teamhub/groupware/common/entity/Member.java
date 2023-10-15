package org.teamhub.groupware.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "MEMBERS")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 30, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 1000)
    private String password;

    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @Column(name = "email", nullable = true, length = 100, unique = true)
    private String email;

    @Column(name = "tel", nullable = true, length = 45)
    private String tel;

    @Column(name = "hp", nullable = true, length = 45)
    private String hp;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "created_by", nullable = true, length = 30)
    private String createdBy;

    @Column(name = "department", nullable = true, length = 30)
    private String department;

    @Column(name = "position", nullable = true, length = 10)
    private String position;

    @Column(name = "rdate", nullable = true)
    private LocalDateTime rdate;
    // 수정 삭제
    @Column(name = "ldate", nullable = true)
    private LocalDateTime ldate;


}
