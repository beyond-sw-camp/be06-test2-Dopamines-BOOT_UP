package dev.dopamines.boot_up.board.project.repository;

import dev.dopamines.boot_up.board.project.model.request.ProjectBoardReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectBoardRepository {
    private JdbcTemplate jdbcTemplate;

    public ProjectBoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(ProjectBoardReq dto) {
        return jdbcTemplate.update("INSERT INTO project (title, video, contents, course_num, team_name, member) VALUES (?,?,?,?,?,?)",
                dto.getTitle(),
                dto.getVideo(),
                dto.getContents(),
                dto.getCourseNum(),
                dto.getTeamName(),
                dto.getMember()
        );
    }
}
