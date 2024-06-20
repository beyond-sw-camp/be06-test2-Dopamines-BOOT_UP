package dev.dopamines.boot_up.board.project.service;

import dev.dopamines.boot_up.board.project.model.request.ProjectBoardReq;
import dev.dopamines.boot_up.board.project.model.response.ProjectBoardRes;
import dev.dopamines.boot_up.board.project.repository.ProjectBoardRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectBoardService {
    private ProjectBoardRepository repository;

    public ProjectBoardService(ProjectBoardRepository repository) {
        this.repository = repository;
    }

    public int add(ProjectBoardReq dto) {
       return repository.save(dto);
    }

    public ProjectBoardRes findById(int idx) {
        return repository.findById(idx);
    }

    public List<ProjectBoardRes> findAll(){
        return repository.findAll();
    }

    public int delete(int idx) {
        return repository.delete(idx);
    }

    public int update(int idx, ProjectBoardReq projectBoardReq) {
        return repository.update(idx, projectBoardReq);
    }
}
