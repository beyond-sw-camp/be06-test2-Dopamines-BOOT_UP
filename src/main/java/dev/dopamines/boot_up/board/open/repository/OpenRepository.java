package dev.dopamines.boot_up.board.open.repository;

import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
import dev.dopamines.boot_up.board.open.model.request.OpenUpdateReq;
import dev.dopamines.boot_up.board.open.model.response.OpenReadRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OpenRepository {

    private final JdbcTemplate jdbcTemplate;

    public OpenRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(OpenCreateReq dto) {
        String sql = """
                INSERT INTO open_board
                (title, content, author, image)
                VALUES 
                (?, ?, ?, null);
                """;

        jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getAuthor());
    }

    public List<OpenReadRes> findAll() {
        String sql = "SELECT title, content, author, image FROM open_board";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new OpenReadRes(
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("author"),
                rs.getString("image")
        ));
    }

    public OpenReadRes findById(int idx) {
        String sql = "SELECT title, content, author, image FROM open_board WHERE idx = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idx}, (rs, rowNum) -> new OpenReadRes(
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("author"),
                rs.getString("image")
        ));
    }

    public void update(OpenUpdateReq dto) {
        String sql = "UPDATE open_board SET title = ?, content = ?, author = ?, image = ? WHERE idx = ?";
        jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getAuthor(), dto.getImage());
    }
}
