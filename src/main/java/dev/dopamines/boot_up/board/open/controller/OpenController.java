package dev.dopamines.boot_up.board.open.controller;
import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
import dev.dopamines.boot_up.board.open.model.response.OpenCreateRes;
import dev.dopamines.boot_up.board.open.service.OpenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/open")
public class OpenController {
    private OpenService openService;

    public OpenController(OpenService openService) {
        this.openService = openService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<OpenCreateRes> create(@RequestBody OpenCreateReq dto) {
        OpenCreateRes response = openService.create(dto);
        return ResponseEntity.ok(response);
    }
}