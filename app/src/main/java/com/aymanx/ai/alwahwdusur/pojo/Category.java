package com.aymanx.ai.alwahwdusur.pojo;

public class Category {

    private int userId;
    private int id;
    private String title;
    private String body;

    public Category(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
  /*private String productName;
    private String productDescription;
    private int photoID;

    public Category(String productName, String productDescription, int photoID) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.photoID = photoID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getPhotoID() {
        return photoID;
    }*/