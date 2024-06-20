package dev.dopamines.boot_up.board.market.model.request;

import java.time.LocalDateTime;

public class MarketBoardCreateReq {
//    private Long idx;
    private String title;
    private String content;
    private String image;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private Integer status;
    private Integer price;
//    private String userName;


    public MarketBoardCreateReq(String title, String content, String image, Integer price) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
