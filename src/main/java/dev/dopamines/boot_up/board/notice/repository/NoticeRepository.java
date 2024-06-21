package dev.dopamines.boot_up.board.notice.repository;

import dev.dopamines.boot_up.board.notice.model.request.NoticeCreateReq;
import dev.dopamines.boot_up.board.notice.model.response.NoticeReadRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeRepository {

    private JdbcTemplate jdbcTemplate;

    public NoticeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(NoticeCreateReq dto) {
        String sql = """
                INSERT INTO notice
                (title, contents, image, created_at, updated_at, admin_idx, file, course_num)
                 values
                 (?, ?, null, now(), now(), ?, null, null);
                """;

        int result = jdbcTemplate.update(sql, dto.getTitle(), dto.getContents(), 1);

        return result;
    }

    public int update(NoticeCreateReq dto) {
        String sql = """
                UPDATE notice
                SET title=?, contents=?, image=?, updated_at=now(), admin_idx=?, file=?, course_num=?
                WHERE idx=?
                """;

        int result = jdbcTemplate.update(sql, dto.getTitle(), dto.getContents(), dto.getImage(), 1, dto.getFile(), dto.getCourseNum(), 113);

        return result;
    }

    public List<NoticeReadRes> findAll() {
        String sql = """
                SELECT notice.title, notice.contents, admin.name, notice.created_at FROM notice LEFT JOIN admin ON notice.admin_idx = admin.idx
                """;
        List<NoticeReadRes> noticeReadRes = jdbcTemplate.query(
                sql,
                // 실행 결과를 DTO로 옮기는 코드 작성
                (rs, rownum) -> {
                    NoticeReadRes result = new NoticeReadRes(
                            rs.getString("notice.title"),
                            rs.getString("notice.contents"),
                            rs.getString("admin.name"),
                            rs.getTimestamp("notice.created_at")
                    );
                    return result;
                }
        );

        return noticeReadRes;
    }

    public NoticeReadRes findById(int idx) {
        String sql = """
                SELECT notice.title, notice.contents, admin.name, notice.created_at
                FROM notice LEFT JOIN admin ON notice.admin_idx = admin.idx
                WHERE notice.idx=?
                """;
        NoticeReadRes noticeReadRes = jdbcTemplate.queryForObject(
                sql,
                // 실행 결과를 DTO로 옮기는 코드 작성
                (rs, rownum) -> {
                    NoticeReadRes result = new NoticeReadRes(
                            rs.getString("notice.title"),
                            rs.getString("notice.contents"),
                            rs.getString("admin.name"),
                            rs.getTimestamp("notice.created_at")
                    );
                    return result;
                },
                idx
        );

        return noticeReadRes;
    }
    public int delete(int idx) {
        String sql = """
                DELETE FROM notice
                WHERE idx=?
                """;

        int result = jdbcTemplate.update(sql, idx);

        return result;

    }

}
