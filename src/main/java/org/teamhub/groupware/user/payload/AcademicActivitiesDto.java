package org.teamhub.groupware.user.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AcademicActivitiesDto {
    private Long id;
    private String academicDate;
    private String description;
    private String writerId;
    private LocalDateTime registDate;
    private String updaterId;
    private LocalDateTime updateDate;

    @QueryProjection
    public AcademicActivitiesDto(Long id, String academicDate, String description, String writerId, LocalDateTime registDate, String updaterId, LocalDateTime updateDate){
        this.id = id;
        this.academicDate = academicDate;
        this.description = description;
        this.writerId = writerId;
        this.registDate = registDate;
        this.updaterId = updaterId;
        this.updateDate = updateDate;
    }
}
