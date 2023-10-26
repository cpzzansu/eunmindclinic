package org.teamhub.groupware.board.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.board.entity.NoticeBoard;
import org.teamhub.groupware.board.mapper.NoticeBoardMapper;
import org.teamhub.groupware.board.payload.NoticeBoardDto;
import org.teamhub.groupware.board.repository.NoticeBoardRepository;

import java.util.ArrayList;
import java.util.List;

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
}
