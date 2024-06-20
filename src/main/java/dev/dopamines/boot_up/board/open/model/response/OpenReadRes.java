package dev.dopamines.boot_up.board.open.model.response;

public class OpenReadRes {
    String title;
    String content;
    String author;
    String image;

    public OpenReadRes(String title, String content, String author, String image) {
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
