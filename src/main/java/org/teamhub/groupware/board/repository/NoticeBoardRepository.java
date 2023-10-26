package org.teamhub.groupware.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teamhub.groupware.board.entity.NoticeBoard;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
}
