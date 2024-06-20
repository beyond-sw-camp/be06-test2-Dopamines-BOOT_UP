package dev.dopamines.boot_up.board.notice.controller;

import dev.dopamines.boot_up.board.notice.model.request.NoticeCreateReq;
import dev.dopamines.boot_up.board.notice.model.response.NoticeCreateRes;
import dev.dopamines.boot_up.board.notice.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/notice")
public class NoticeController {
    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<NoticeCreateRes> create(@RequestBody NoticeCreateReq dto) {
        NoticeCreateRes response = noticeService.create(dto);
        return ResponseEntity.ok(response);
    }
}
