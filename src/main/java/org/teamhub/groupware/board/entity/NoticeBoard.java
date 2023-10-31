package org.teamhub.groupware.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.teamhub.groupware.board.payload.NoticeBoardDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "notice_board")
public class NoticeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notice_board_title", nullable = false, length = 200)
    private String noticeBoardTitle;

    @Column(name = "notice_board_content", nullable = false, length = 10000)
    private String noticeBoardContent;

    @Column(name = "notice_check")
    private int noticeCheck;

    @Column(name = "writer_id", nullable = false, length = 100)
    private String writerId;

    @Column(name = "regist_date")
    private LocalDateTime registDate;

    @Column(name = "view_count")
    private int viewCount;

    @Column(name = "updater_id")
    private String updaterId;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public void increaseViewCount(){
        this.viewCount++;
    }

    public void modifyNoticeBoard(NoticeBoardDto noticeBoardDto){
        this.noticeBoardTitle = noticeBoardDto.getNoticeBoardTitle();
        this.noticeBoardContent = noticeBoardDto.getNoticeBoardContent();
        this.noticeCheck = noticeBoardDto.getNoticeCheck();
        this.updaterId = noticeBoardDto.getUpdaterId();
        this.updateDate = LocalDateTime.now();
    }
}
