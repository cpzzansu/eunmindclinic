package org.teamhub.groupware.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "published_works")
public class PublishedWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "published_works", nullable = false, length = 500)
    private String publishedWorks;

    @Column(name = "writer_id", nullable = false, length = 100)
    private String writerId;

    @Column(name = "regist_date")
    private LocalDateTime registDate;

    @Column(name = "updater_id")
    private String updaterId;

    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
