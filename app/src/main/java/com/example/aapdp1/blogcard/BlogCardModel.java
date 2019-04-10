package com.example.aapdp1.blogcard;

public class BlogCardModel {
    private String title,body,image;
    private int likes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public BlogCardModel(String title, String body, String image, int likes) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.likes = likes;
    }
}
