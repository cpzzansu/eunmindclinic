package org.teamhub.groupware.board.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class NoticeBoardDto {
    private Long id;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private int noticeCheck;
    private String writerId;
    private LocalDateTime registDate;
    private int viewCount;
    private String updaterId;
    private LocalDateTime updateDate;
    private Long number;


    @QueryProjection
    public NoticeBoardDto(Long id, String noticeBoardTitle, String noticeBoardContent, int noticeCheck,  String writerId, LocalDateTime registDate, int viewCount, String updaterId, LocalDateTime updateDate, Long number){
        this.id = id;
        this.noticeBoardTitle = noticeBoardTitle;
        this.noticeBoardContent = noticeBoardContent;
        this.noticeCheck = noticeCheck;
        this.writerId = writerId;
        this.registDate = registDate;
        this.viewCount = viewCount;
        this.updaterId = updaterId;
        this.updateDate = updateDate;
        this.number = number;
    }
}
