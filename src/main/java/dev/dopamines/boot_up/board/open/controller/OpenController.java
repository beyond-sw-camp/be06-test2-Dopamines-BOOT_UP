package dev.dopamines.boot_up.board.open.controller;

import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
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

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int idx) {
        openService.delete(idx);
        return ResponseEntity.ok("삭제 완료");
    }
}
