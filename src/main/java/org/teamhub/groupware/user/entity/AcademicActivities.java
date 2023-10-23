package org.teamhub.groupware.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "ACADEMICACTIVITIES")
public class AcademicActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
