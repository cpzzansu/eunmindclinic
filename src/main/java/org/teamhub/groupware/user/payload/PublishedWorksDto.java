package org.teamhub.groupware.user.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PublishedWorksDto {
    private Long id;
    private String publishedWorks;
    private String writerId;
    private LocalDateTime registDate;
    private String updaterId;
    private LocalDateTime updateDate;

    @QueryProjection
    public PublishedWorksDto(Long id, String publishedWorks, String writerId, LocalDateTime registDate, String updaterId, LocalDateTime updateDate){
        this.id = id;
        this.publishedWorks = publishedWorks;
        this.writerId = writerId;
        this.registDate = registDate;
        this.updaterId = updaterId;
        this.updateDate = updateDate;
    }
}
