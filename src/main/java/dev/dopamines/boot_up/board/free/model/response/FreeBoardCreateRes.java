package dev.dopamines.boot_up.board.free.model.response;

import java.sql.Timestamp;

public class FreeBoardCreateRes {
    private String title;
    private String contents;
    private String image;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int user_idx;
    private String file;
    private int courseNum;

    public FreeBoardCreateRes(String title) {
        this.title = title;
        this.contents = contents;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user_idx = user_idx;
        this.file = file;
        this.courseNum = courseNum;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }
}
