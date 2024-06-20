package dev.dopamines.boot_up.board.open.service;

import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
import dev.dopamines.boot_up.board.open.model.response.OpenCreateRes;
import dev.dopamines.boot_up.board.open.model.response.OpenReadRes;
import dev.dopamines.boot_up.board.open.repository.OpenRepository;
import org.springframework.stereotype.Service;

@Service
public class OpenService {

    private final OpenRepository openRepository;

    public OpenService(OpenRepository openRepository) {
        this.openRepository = openRepository;
    }

    public OpenCreateRes create(OpenCreateReq dto) {
        openRepository.create(dto);
        return new OpenCreateRes(dto.getTitle() + " 저장됨");
    }

    public OpenReadRes read(int idx) {
        return openRepository.findById(idx);
    }
}
