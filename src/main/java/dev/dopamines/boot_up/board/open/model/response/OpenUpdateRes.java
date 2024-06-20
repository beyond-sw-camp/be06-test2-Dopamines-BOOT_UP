package dev.dopamines.boot_up.board.open.model.response;

import java.sql.Timestamp;

public class OpenUpdateRes {
    String title;
    String content;
    String author;
    String image;
    Timestamp created_at;
    Timestamp updated_at;

    public OpenUpdateRes(String title, String content, String author, String image, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public OpenUpdateRes() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
