package org.teamhub.groupware.board.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.board.entity.NoticeBoard;
import org.teamhub.groupware.board.mapper.NoticeBoardMapper;
import org.teamhub.groupware.board.payload.NoticeBoardDto;
import org.teamhub.groupware.board.repository.NoticeBoardRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;

    public List<NoticeBoardDto> getNoticeBoard(){

        List<NoticeBoard> noticeBoardList = noticeBoardRepository.findAll();

        List<NoticeBoardDto> noticeBoardDtoList = new ArrayList<>();

        for(NoticeBoard noticeBoard : noticeBoardList){

            NoticeBoardDto noticeBoardDto = NoticeBoardMapper.toDto(noticeBoard);

            noticeBoardDto.setNumber(noticeBoardDto.getId());

            noticeBoardDtoList.add(noticeBoardDto);
        }

        return noticeBoardDtoList;
    }

    public NoticeBoardDto getNoticeBoardDetail(String id) {
        Long longId = Long.parseLong(id);
        NoticeBoard  noticeBoard = noticeBoardRepository.getReferenceById(longId);
        return NoticeBoardMapper.toDto(noticeBoard);
    }

    public void noticeBoardAdd(NoticeBoardDto noticeBoardDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        noticeBoardDto.setWriterId(authentication.getName());
        noticeBoardDto.setRegistDate(LocalDateTime.now());
        NoticeBoard noticeBoard = NoticeBoardMapper.toEntity(noticeBoardDto);
        noticeBoardRepository.save(noticeBoard);
    }

    public void noticeBoardModify(NoticeBoardDto noticeBoardDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        noticeBoardDto.setUpdaterId(authentication.getName());

        Long id = noticeBoardDto.getId();

        Optional<NoticeBoard> noticeBoard = noticeBoardRepository.findById(id);

        if(noticeBoard.isPresent()){
            noticeBoard.get().modifyNoticeBoard(noticeBoardDto);
        }
    }
}
