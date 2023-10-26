package org.teamhub.groupware.user.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MbaDto {
    private Long id;
    private String mbaContent;
    private String writerId;
    private LocalDateTime registDate;
    private String updaterId;
    private LocalDateTime updateDate;

    @QueryProjection
    public MbaDto(Long id, String mbaContent, String writerId, LocalDateTime registDate, String updaterId, LocalDateTime updateDate){
        this.id = id;
        this.mbaContent = mbaContent;
        this.writerId = writerId;
        this.registDate = registDate;
        this.updaterId = updaterId;
        this.updateDate = updateDate;
    }
}
