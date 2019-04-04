package com.example.tarea4.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class itemProduct implements Parcelable {
    private String title;

    private String phone;
    private int image;
    private String location;
    private String description;
    private int code;
    private	Store	store;
    private	Category category;



    public itemProduct(int code,String title, Store store, String phone, int image, String location) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.image = image;
        this.location= location;
    }

    public itemProduct(String title, Store store, String phone, int image, String location) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.image = image;
        this.location= location;
    }

    public itemProduct() {
        this.title = "";
        this.store = new Store();
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

    public Store getStore() {
        return store;
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

    public void setStore(Store store) {
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static Creator<itemProduct> getCREATOR() {
        return CREATOR;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.phone);
        dest.writeInt(this.image);
        dest.writeString(this.location);
        dest.writeString(this.description);
        dest.writeInt(this.code);
        dest.writeParcelable(this.store, flags);
        dest.writeParcelable(this.category, flags);
    }

    protected itemProduct(Parcel in) {
        this.title = in.readString();
        this.phone = in.readString();
        this.image = in.readInt();
        this.location = in.readString();
        this.description = in.readString();
        this.code = in.readInt();
        this.store = in.readParcelable(Store.class.getClassLoader());
        this.category = in.readParcelable(Category.class.getClassLoader());
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
