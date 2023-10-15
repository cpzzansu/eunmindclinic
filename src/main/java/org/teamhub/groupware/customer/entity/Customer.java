package org.teamhub.groupware.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.teamhub.groupware.common.entity.Member;

import java.time.LocalDateTime;

/**
 * 고객 관리 테이블
 * EMPLOYEE 담당
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "CUSTOMERS", indexes = @Index(name = "IX_member_id", columnList = "id"))
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "company", nullable = true, length = 30)
    private String company;

    @Column(name = "department", nullable = true, length = 30)
    private String department;

    @Column(name = "position", nullable = true, length = 30)
    private String position;

    @Column(name = "name", nullable = true, length = 15)
    private String name;

    @Column(name = "email", nullable = true, length = 30)
    private String email;

    @Column(name = "tel", nullable = true, length = 45)
    private String tel;

    @Column(name = "hp", nullable = true, length = 45)
    private String hp;

    @Column(name = "rdate", nullable = true)
    private LocalDateTime rdate;
    // 수정 삭제
    @Column(name = "ldate", nullable = true)
    private LocalDateTime ldate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;

}
