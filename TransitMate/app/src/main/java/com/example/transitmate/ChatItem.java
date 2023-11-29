package com.example.transitmate;

public class ChatItem {

    String imgResource = "";
    String name = "";

    public ChatItem(String name, String imgResource) {
        this.imgResource = imgResource;
        this.name = name;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void setImgResource(String imgResource) {
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
