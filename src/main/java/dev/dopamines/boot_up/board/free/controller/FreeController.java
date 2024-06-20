package dev.dopamines.boot_up.board.free.controller;

import dev.dopamines.boot_up.board.free.model.request.FreeCreateReq;
import dev.dopamines.boot_up.board.free.model.response.FreeBoardCreateRes;
import dev.dopamines.boot_up.board.free.model.response.FreeReadRes;
import dev.dopamines.boot_up.board.free.service.FreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/free")
public class FreeController {
    private FreeService freeService;

    public FreeController(FreeService freeBoardService) {
        this.freeService = freeBoardService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<FreeBoardCreateRes> create(@RequestBody FreeCreateReq dto){
        FreeBoardCreateRes response = FreeService.create(dto);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity<FreeReadRes> read(int idx){
        FreeReadRes response = FreeService.read(idx);
        return ResponseEntity.ok(response);
    }
}
