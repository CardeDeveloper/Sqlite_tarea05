package com.example.tarea2.beans;

public class itemProduct {
    private String title;
    private String store;
    private String phone;
    private int image;
    private String location;
    private String description;





    public itemProduct(String title, String store, String phone, int image, String location) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.image = image;
        this.location= location;
    }

    public itemProduct() {
        this.title = "";
        this.store = "";
        this.phone = "";
        this.image = 0;
    }

    @Override
    public String toString() {
        return "itemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", image=" + image +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
