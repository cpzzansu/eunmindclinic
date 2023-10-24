package org.teamhub.groupware.user.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OverseasPresentationDto {
    private Long id;
    private String overseasPresentation;
    private String writerId;
    private LocalDateTime registDate;
    private String updaterId;
    private LocalDateTime updateDate;

    @QueryProjection
    public OverseasPresentationDto(Long id, String overseasPresentation, String writerId, LocalDateTime registDate, String updaterId, LocalDateTime updateDate){
        this.id = id;
        this.overseasPresentation = overseasPresentation;
        this.writerId = writerId;
        this.registDate = registDate;
        this.updaterId = updaterId;
        this.updateDate = updateDate;
    }
}
