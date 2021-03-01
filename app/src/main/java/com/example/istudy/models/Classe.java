package com.example.istudy.models;

public class Classe {
    private String title;
    private String imgUrl;
    private int drawableResource;
    public Classe(int drawableResource) {
        this.drawableResource = drawableResource;
    }
    public Classe() {
    }

    public Classe(String title, String imgUrl, int drawableResource) {
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
