package dev.dopamines.boot_up.board.open.repository;

import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OpenRepository {

    private JdbcTemplate jdbcTemplate;

    public OpenRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(OpenCreateReq dto) {
        String sql = """
                INSERT INTO open_board
                (title, content, author, image, created_at, updated_at)
                 values 
                 (?, ?, ?, null, now(), now());
                """;

        jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), 1);
    }

}