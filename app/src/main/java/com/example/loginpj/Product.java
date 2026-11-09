package com.example.loginpj;

public class Product {
    private String name;
    private String price;
    private String soldInfo;
    private String tag;
    private int imageResId;

    public Product(String name, String price, String soldInfo, String tag, int imageResId) {
        this.name = name;
        this.price = price;
        this.soldInfo = soldInfo;
        this.tag = tag;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSoldInfo() {
        return soldInfo;
    }

    public String getTag() {
        return tag;
    }

    public int getImageResId() {
        return imageResId;
    }
}
