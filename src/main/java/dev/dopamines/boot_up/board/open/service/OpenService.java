package dev.dopamines.boot_up.board.open.service;

import dev.dopamines.boot_up.board.open.model.request.OpenCreateReq;
import dev.dopamines.boot_up.board.open.repository.OpenRepository;
import dev.dopamines.boot_up.board.open.model.response.OpenCreateRes;
import dev.dopamines.boot_up.board.open.model.response.OpenReadRes;
import dev.dopamines.boot_up.board.open.model.response.OpenUpdateRes;
import dev.dopamines.boot_up.board.open.model.response.OpenDeleteRes;
import org.springframework.stereotype.Service;

@Service
public class OpenService {

    public OpenService(OpenRepository openRepository) {
    }

    public OpenCreateRes create(OpenCreateReq dto){
        return new OpenCreateRes();
    }

    public OpenReadRes read(int id) {
        return new OpenReadRes();
    }

    public OpenUpdateRes update(int idx) {
        return new OpenUpdateRes();
    }

    public OpenDeleteRes delete(int idx) {
        return new OpenDeleteRes();
    }


}
