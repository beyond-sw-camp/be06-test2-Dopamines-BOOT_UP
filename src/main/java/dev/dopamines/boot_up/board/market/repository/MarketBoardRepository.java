package dev.dopamines.boot_up.board.market.repository;

import dev.dopamines.boot_up.board.market.model.request.MarketBoardCreateReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MarketBoardRepository {

    private JdbcTemplate jdbcTemplate;

    public MarketBoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(MarketBoardCreateReq reqDto){
//INSERT INTO `market_board` VALUES (1,'Police Academy 5: Assignment: Miami Beach',
// 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.\n\n'
// ,'http://dummyimage.com/231x100.png/5fa2dd/ffffff','2023-10-07 00:00:00','2024-02-16 00:00:00',1,59392,3);
        return jdbcTemplate.update("INSERT INTO market_board (title, content,image,created_at,update_at,status,price,user_idx) VALUES (?,?,?,?,?,?,?,?)",
                reqDto.getTitle(),
                reqDto.getContent(),
                reqDto.getImage(),
                "2002-10-10",   // Todo : DateTime 형식에는 문자열 들어가면 안됨
                "2002-10-10",
                1,
                reqDto.getPrice(),
                1
        );
    }

}
