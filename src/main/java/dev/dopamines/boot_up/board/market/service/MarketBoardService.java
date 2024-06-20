package dev.dopamines.boot_up.board.market.service;

import dev.dopamines.boot_up.board.market.model.request.MarketBoardCreateReq;
import dev.dopamines.boot_up.board.market.repository.MarketBoardRepository;
import org.springframework.stereotype.Service;

@Service
public class MarketBoardService {

    private MarketBoardRepository marketBoardRepository;

    public MarketBoardService(MarketBoardRepository marketBoardRepository) {
        this.marketBoardRepository = marketBoardRepository;
    }

    public String create(MarketBoardCreateReq reqDto){
        if(marketBoardRepository.save(reqDto)>0){
            return "저장 성공";
        } else{
            return "저장 실패";
        }
    }
}
