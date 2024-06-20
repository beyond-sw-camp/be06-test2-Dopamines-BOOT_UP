package dev.dopamines.boot_up.board.project.controller;

import dev.dopamines.boot_up.board.project.model.request.ProjectBoardReq;
import dev.dopamines.boot_up.board.project.model.response.ProjectBoardRes;
import dev.dopamines.boot_up.board.project.service.ProjectBoardService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(method=RequestMethod.GET, value = "/{idx}")
    public ResponseEntity<?> findProjectById(@PathVariable("idx") int idx) {
        ProjectBoardRes res = service.findById(idx);
        if (res == null) {
            return ResponseEntity.ok("해당 프로젝트 게시물을 찾지 못했습니다.");
        }
        return ResponseEntity.ok(res);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<ProjectBoardRes> res = service.findAll();
        if (res == null) {
            return ResponseEntity.ok("프로젝트 게시물들을 찾지 못했습니다.");
        }
        return ResponseEntity.ok(res);
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/{idx}")
    public ResponseEntity<?> delete(@PathVariable("idx") int idx) {
        int result = service.delete(idx);
        if (result <= 0) {
            return ResponseEntity.ok("게시물 삭제에 실패했습니다.");
        }
        return ResponseEntity.ok("게시물 삭제에 성공했습니다.");
    }

    @RequestMapping(method=RequestMethod.PUT, value = "/{idx}")
    public ResponseEntity<?> updateProjectPost(@PathVariable("idx")int idx, @RequestBody ProjectBoardReq projectBoardReq) {
        int result = service.update(idx, projectBoardReq);
        if (result <= 0) {
            return ResponseEntity.ok("게시물 수정에 실패했습니다.");
        }
        return ResponseEntity.ok("게시물 수정에 성공했습니다.");
    }
}
