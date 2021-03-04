package com.example.istudy.models;

public class Grade1 {
    private String title;
    private String imgUrl;
    private int drawableResource;
    public Grade1(int drawableResource) {
        this.drawableResource = drawableResource;
    }
    public Grade1() {
    }

    public Grade1(String title, String imgUrl, int drawableResource) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.drawableResource = drawableResource;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
