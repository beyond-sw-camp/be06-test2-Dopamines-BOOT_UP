package dev.dopamines.boot_up.board.notice.model.response;

import java.sql.Timestamp;

public class NoticeReadRes {
    private String title;
    private String contents;
    private String name;
    private Timestamp createdAt;

    public NoticeReadRes(String title, String contents, String name, Timestamp createdAt) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
