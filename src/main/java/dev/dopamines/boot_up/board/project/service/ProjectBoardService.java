package dev.dopamines.boot_up.board.project.service;

import dev.dopamines.boot_up.board.project.model.request.ProjectBoardReq;
import dev.dopamines.boot_up.board.project.model.response.ProjectBoardRes;
import dev.dopamines.boot_up.board.project.repository.ProjectBoardRepository;
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

}
