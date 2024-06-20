package dev.dopamines.boot_up.board.project.controller;

import dev.dopamines.boot_up.board.project.model.request.ProjectBoardReq;
import dev.dopamines.boot_up.board.project.service.ProjectBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectBoardController {
    private ProjectBoardService service;

    public ProjectBoardController(ProjectBoardService service) {
        this.service = service;
    }

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity createProjectPost(@RequestBody ProjectBoardReq projectReq) {
        int result = service.add(projectReq);
        if (result <= 0) {
            return ResponseEntity.ok("게시글이 저장되지 않음");
        }
        return ResponseEntity.ok("게시글이 저장됨");
    }
}
