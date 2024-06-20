package dev.dopamines.boot_up.board.free.service;

import dev.dopamines.boot_up.board.free.model.request.FreeCreateReq;
import dev.dopamines.boot_up.board.free.model.response.FreeBoardCreateRes;
import dev.dopamines.boot_up.board.free.model.response.FreeReadRes;
import dev.dopamines.boot_up.board.free.repository.FreeBoardRepository;
import org.springframework.stereotype.Service;

@Service
public class FreeService {
    private static FreeBoardRepository freeBoardRepository;

    public FreeService(FreeBoardRepository freeBoardRepository) {
        this.freeBoardRepository = freeBoardRepository;
    }

    public static FreeBoardCreateRes create(FreeCreateReq dto){
        freeBoardRepository.create(dto);
        return new FreeBoardCreateRes(dto.getTitle()+ " 저장됨");
    }

    public static FreeReadRes read(int idx) {
        FreeReadRes freeReadRes = freeBoardRepository.findByIdx(idx);
        return freeReadRes;
    }
}
