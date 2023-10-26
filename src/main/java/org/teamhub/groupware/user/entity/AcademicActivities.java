package org.teamhub.groupware.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "academic_activities")
public class AcademicActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "academic_date", nullable= false, length=20)
    private String academicDate;

    @Column(name="description", nullable = false, length = 100)
    private String description;

    @Column(name="writer_id", nullable = false, length = 50)
    private String writerId;

    @Column(name="regist_date")
    private LocalDateTime registDate;

    @Column(name="updater_id")
    private String updaterId;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Override
    public String toString() {
        return "AcademicActivities{" +
                "id=" + id +
                ", date='" + academicDate + '\'' +
                ", description='" + description + '\'' +
                ", writerId='" + writerId + '\'' +
                ", registDate=" + registDate +
                ", updaterId='" + updaterId + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
