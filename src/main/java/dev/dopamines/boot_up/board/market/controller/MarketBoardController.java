package dev.dopamines.boot_up.board.market.controller;

import dev.dopamines.boot_up.board.market.model.request.MarketBoardCreateReq;
import dev.dopamines.boot_up.board.market.service.MarketBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Todo : 만일, 모든게 완벽한데 컨트롤러를 못 찾는다면, run 실행파일 과 같은 depth에 있는지 확인할 것!

@RestController
@RequestMapping(value = "/market")
public class MarketBoardController {
    private MarketBoardService marketBoardService;

    public MarketBoardController(MarketBoardService marketBoardService) {
        this.marketBoardService = marketBoardService;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("테스트");
    }

    @RequestMapping(method = RequestMethod.POST, value ="/create")
    public ResponseEntity<String> create(@RequestBody MarketBoardCreateReq reqDto){
        return ResponseEntity.ok(marketBoardService.create(reqDto));
    }

}
