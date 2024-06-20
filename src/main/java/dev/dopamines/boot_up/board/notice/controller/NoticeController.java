package dev.dopamines.boot_up.board.notice.controller;

import com.sun.jna.platform.win32.WinNT;
import dev.dopamines.boot_up.board.notice.model.request.NoticeCreateReq;
import dev.dopamines.boot_up.board.notice.model.response.NoticeCreateRes;
import dev.dopamines.boot_up.board.notice.model.response.NoticeReadRes;
import dev.dopamines.boot_up.board.notice.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/board/notice")
public class NoticeController {
    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(@RequestBody NoticeCreateReq dto) {
        int result = noticeService.create(dto);
        if(result <= 0) {
            return ResponseEntity.ok("게시글이 저장되지 않음");
        } else {
            return ResponseEntity.ok("게시글이 저장됨");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity update(@RequestBody NoticeCreateReq dto) {
        int result = noticeService.update(dto);
        if(result <= 0) {
            return ResponseEntity.ok("게시글이 수정되지 않음");
        } else {
            return ResponseEntity.ok("게시글이 수정됨");
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    public ResponseEntity<List<NoticeReadRes>> findAll() {

        List<NoticeReadRes> result = noticeService.findAll();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findById")
    public ResponseEntity<NoticeReadRes> findById(@RequestParam("idx") int idx) {

        NoticeReadRes result = noticeService.find(idx);
        return ResponseEntity.ok(result);

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public ResponseEntity delete(@RequestParam int idx) {
        int result = noticeService.delete(idx);

        if(result <= 0) {
            return ResponseEntity.ok("게시글이 삭제되지 않음");
        } else {
            return ResponseEntity.ok("게시글이 삭제됨");
        }

    }
}
