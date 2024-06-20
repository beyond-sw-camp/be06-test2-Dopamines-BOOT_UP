package dev.dopamines.boot_up.board.free.model.request;


import java.sql.Timestamp;

public class FreeCreateReq {
    private String title;
    private String content;
    private String author;
    private String image;

    public FreeCreateReq(){
    }

    public FreeCreateReq(String title, String content, String author, String image, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.image = image;
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

}
