package dev.dopamines.boot_up.board.project.repository;

import dev.dopamines.boot_up.board.project.model.request.ProjectBoardReq;
import dev.dopamines.boot_up.board.project.model.response.ProjectBoardRes;
import java.util.List;
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

    public ProjectBoardRes findById(int idx) {
        ProjectBoardRes project = jdbcTemplate.queryForObject("SELECT * FROM project where idx = ?",
                (rs, rownum) -> {
                    ProjectBoardRes res = new ProjectBoardRes(
                            rs.getLong("idx"),
                            rs.getString("title"),
                            rs.getString("video"),
                            rs.getString("contents"),
                            rs.getInt("course_num"),
                            rs.getString("team_name"),
                            rs.getString("member")
                    );
                    return res;
                },
                idx);
        return project;
    }

    public List<ProjectBoardRes> findAll() {
        List<ProjectBoardRes> projects = jdbcTemplate.query(
                "SELECT * FROM project",
                (rs, rownum) -> {
                    ProjectBoardRes res = new ProjectBoardRes(
                            rs.getLong("idx"),
                            rs.getString("title"),
                            rs.getString("video"),
                            rs.getString("contents"),
                            rs.getInt("course_num"),
                            rs.getString("team_name"),
                            rs.getString("member")
                    );
                    return res;
                }
        );
        return projects;
    }

    public int delete(int idx) {
        return jdbcTemplate.update("DELETE FROM project WHERE idx = ? ",idx);
    }
}
