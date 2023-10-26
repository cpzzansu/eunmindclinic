package org.teamhub.groupware.board.mapper;

import org.teamhub.groupware.board.entity.NoticeBoard;
import org.teamhub.groupware.board.payload.NoticeBoardDto;
import org.teamhub.groupware.user.entity.Mba;
import org.teamhub.groupware.user.payload.MbaDto;

public class NoticeBoardMapper {
    public static NoticeBoardDto toDto(NoticeBoard noticeBoard){
        NoticeBoardDto.NoticeBoardDtoBuilder builder = NoticeBoardDto.builder()
                .id(noticeBoard.getId())
                .noticeBoardTitle(noticeBoard.getNoticeBoardTitle())
                .noticeBoardContent(noticeBoard.getNoticeBoardContent())
                .noticeCheck(noticeBoard.getNoticeCheck())
                .writerId(noticeBoard.getWriterId())
                .registDate(noticeBoard.getRegistDate())
                .viewCount(noticeBoard.getViewCount())
                .updaterId(noticeBoard.getUpdaterId())
                .updateDate(noticeBoard.getUpdateDate());

        return builder.build();
    }

    public static NoticeBoard toEntity(NoticeBoardDto noticeBoardDto){
        NoticeBoard.NoticeBoardBuilder builder = NoticeBoard.builder()
                .id(noticeBoardDto.getId())
                .noticeBoardTitle(noticeBoardDto.getNoticeBoardTitle())
                .noticeBoardContent(noticeBoardDto.getNoticeBoardContent())
                .noticeCheck(noticeBoardDto.getNoticeCheck())
                .writerId(noticeBoardDto.getWriterId())
                .registDate(noticeBoardDto.getRegistDate())
                .viewCount(noticeBoardDto.getViewCount())
                .updaterId(noticeBoardDto.getUpdaterId())
                .updateDate(noticeBoardDto.getUpdateDate());

        return builder.build();
    }
}
