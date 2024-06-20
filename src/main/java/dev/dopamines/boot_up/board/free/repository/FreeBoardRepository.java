package dev.dopamines.boot_up.board.free.repository;

import dev.dopamines.boot_up.board.free.model.request.FreeCreateReq;
import dev.dopamines.boot_up.board.free.model.response.FreeReadRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardRepository {

    private final JdbcTemplate jdbcTemplate;

    public FreeBoardRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(FreeCreateReq dto){
        String sql = """
                INSERT INTO free_board
                (title,content,author,image,created_at,updated_at, user_idx)
                 values 
                 (?, ?, ?,null, now(), now(), ?);
                """;

        jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getAuthor(), 1);
    }

    public FreeReadRes findByIdx(int idx) {
        FreeReadRes freeReadRes = jdbcTemplate.queryForObject(
                "SELECT * FROM free_board WHERE idx = ?",
                (rs, rowNum) -> {
                    FreeReadRes response = new FreeReadRes(
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("image"),
                            rs.getTimestamp("created_at"),
                            rs.getTimestamp("updated_at")

                    );

                    System.out.println(rs.getTimestamp("created_at"));
                    System.out.println(rs.getTimestamp("updated_at"));
                    return response;
                },
                idx

        );
        return freeReadRes;
    }
}
