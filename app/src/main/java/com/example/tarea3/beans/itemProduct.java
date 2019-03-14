package com.example.tarea3.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class itemProduct implements Parcelable {
    private String title;
    private String store;
    private String phone;
    private int image;
    private String location;
    private String description;
    private int code;



    public itemProduct(int code,String title, String store, String phone, int image, String location) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.image = image;
        this.location= location;
    }

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.store);
        dest.writeString(this.phone);
        dest.writeInt(this.image);
        dest.writeString(this.location);
        dest.writeString(this.description);
        dest.writeInt(this.code);
    }

    protected itemProduct(Parcel in) {
        this.title = in.readString();
        this.store = in.readString();
        this.phone = in.readString();
        this.image = in.readInt();
        this.location = in.readString();
        this.description = in.readString();
        this.code = in.readInt();
    }

    public static final Creator<itemProduct> CREATOR = new Creator<itemProduct>() {
        @Override
        public itemProduct createFromParcel(Parcel source) {
            return new itemProduct(source);
        }

        @Override
        public itemProduct[] newArray(int size) {
            return new itemProduct[size];
        }
    };
}
