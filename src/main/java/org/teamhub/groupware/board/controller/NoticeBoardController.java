package org.teamhub.groupware.board.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.teamhub.groupware.board.payload.NoticeBoardDto;
import org.teamhub.groupware.board.service.NoticeBoardService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @GetMapping("/noticeBoardList")
    public List<NoticeBoardDto> getNoticeBoard(){
        return noticeBoardService.getNoticeBoard();
    }

    @GetMapping("/noticeBoardDetail")
    public NoticeBoardDto getNoticeBoardDetail(@RequestParam(name="id") String id){
        return noticeBoardService.getNoticeBoardDetail(id);
    }

    @PostMapping("/noticeAdd")
    public void noticeBoardAdd(@RequestBody NoticeBoardDto noticeBoardDto){
        noticeBoardService.noticeBoardAdd(noticeBoardDto);
    }

    @PostMapping("/noticeModify")
    public void noticeBoardModify(@RequestBody NoticeBoardDto noticeBoardDto){
        noticeBoardService.noticeBoardModify(noticeBoardDto);
    }
}
