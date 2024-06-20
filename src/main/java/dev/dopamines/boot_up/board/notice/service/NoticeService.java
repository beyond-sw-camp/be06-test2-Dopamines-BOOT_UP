package dev.dopamines.boot_up.board.notice.service;

import dev.dopamines.boot_up.board.notice.model.request.NoticeCreateReq;
import dev.dopamines.boot_up.board.notice.model.response.NoticeCreateRes;
import dev.dopamines.boot_up.board.notice.repository.NoticeRepository;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public NoticeCreateRes create(NoticeCreateReq dto) {
        noticeRepository.create(dto);

        return new NoticeCreateRes(dto.getTitle() + " 저장됨");
    }
}
