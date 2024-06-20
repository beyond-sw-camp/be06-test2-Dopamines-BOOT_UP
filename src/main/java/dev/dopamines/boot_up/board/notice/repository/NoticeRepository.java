package dev.dopamines.boot_up.board.notice.repository;

import dev.dopamines.boot_up.board.notice.model.request.NoticeCreateReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeRepository {

    private JdbcTemplate jdbcTemplate;

    public NoticeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(NoticeCreateReq dto) {
        String sql = """
                INSERT INTO notice 
                (title, contents, image, created_at, updated_at, admin_idx, file, course_num)
                 values 
                 (?, ?, null, now(), now(), ?, null, null);
                """;

        jdbcTemplate.update(sql, dto.getTitle(), dto.getContents(), 1);
    }

}
