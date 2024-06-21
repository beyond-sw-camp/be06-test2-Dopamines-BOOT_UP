package dev.dopamines.boot_up.board.notice.service;

import dev.dopamines.boot_up.board.notice.model.request.NoticeCreateReq;
import dev.dopamines.boot_up.board.notice.model.response.NoticeCreateRes;
import dev.dopamines.boot_up.board.notice.model.response.NoticeReadRes;
import dev.dopamines.boot_up.board.notice.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public int create(NoticeCreateReq dto) {
        int result = noticeRepository.create(dto);

        return result;
    }

    public int update(NoticeCreateReq dto) {
        int result = noticeRepository.update(dto);

        return result;
    }


    public List<NoticeReadRes> findAll() {
        List<NoticeReadRes> noticeReadResList = noticeRepository.findAll();

        return noticeReadResList;
    }

    public NoticeReadRes find(int idx) {
        NoticeReadRes noticeReadRes = noticeRepository.findById(idx);

        return noticeReadRes;
    }
    public int delete(int idx) {
        int result = noticeRepository.delete(idx);

        return result;
    }
}
