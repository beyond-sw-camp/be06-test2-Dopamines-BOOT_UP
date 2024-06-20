package dev.dopamines.boot_up.board.open.controller;

import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
import dev.dopamines.boot_up.board.open.model.request.OpenUpdateReq;
import dev.dopamines.boot_up.board.open.model.response.OpenCreateRes;
import dev.dopamines.boot_up.board.open.model.response.OpenReadRes;
import dev.dopamines.boot_up.board.open.service.OpenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board/open")
public class OpenController {
    private final OpenService openService;

    public OpenController(OpenService openService) {
        this.openService = openService;
    }

    @PostMapping("/create")
    public ResponseEntity<OpenCreateRes> create(@RequestBody OpenCreateReq dto) {
        OpenCreateRes response = openService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read")
    public ResponseEntity<OpenReadRes> read() {
        int idx = 1;
        OpenReadRes response = openService.read(idx);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody OpenUpdateReq dto) {
        openService.update(dto);
        return ResponseEntity.ok("업데이트 완료");
    }
}
