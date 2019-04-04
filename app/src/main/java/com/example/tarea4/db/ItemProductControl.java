package com.example.tarea4.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tarea4.beans.Category;
import com.example.tarea4.beans.itemProduct;

import java.util.ArrayList;

public class ItemProductControl {
    public void addItemProduct(itemProduct itemProduct, DataBaseHandler dh){

        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHandler.KEY_PRODUCT_ID, itemProduct.getCode());
        contentValues.put(DataBaseHandler.KEY_PRODUCT_TITLE, itemProduct.getTitle());
        contentValues.put(DataBaseHandler.KEY_PRODUCT_IMAGE, itemProduct.getImage());
        contentValues.put(DataBaseHandler.KEY_PRODUCT_CATEGORY, itemProduct.getCategory().getId());

        long rowID = db.insert(DataBaseHandler.TABLE_PRODUCT, null, contentValues);

        ContentValues contentValues1 = new ContentValues();

        contentValues1.put(DataBaseHandler.KEY_STORE_PRODUCT_ID, itemProduct.getCode());
        contentValues1.put(DataBaseHandler.KEY_STORE_PRODUCT_ID_STORE, itemProduct.getStore().getId());

        long rowID2 = db.insert(DataBaseHandler.TABLE_STORE_PRODUCT, null, contentValues1);

    }

    public ArrayList<itemProduct> getItemProductsByCategory(int idCategory, DataBaseHandler dh){

        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<itemProduct> itemProducts = new ArrayList<>();

        String select = "SELECT P." + DataBaseHandler.KEY_PRODUCT_ID + ", P." + DataBaseHandler.KEY_PRODUCT_TITLE + ", P." + DataBaseHandler.KEY_PRODUCT_IMAGE + ", P."
                + DataBaseHandler.KEY_PRODUCT_CATEGORY + ", C." + DataBaseHandler.KEY_CATEGORY_ID + ", C." + DataBaseHandler.KEY_CATEGORY_NAME + " FROM " + DataBaseHandler.TABLE_PRODUCT
                + " P, " + DataBaseHandler.TABLE_CATEGORY + " C  WHERE P."
                + DataBaseHandler.KEY_PRODUCT_CATEGORY + " = " + idCategory;

        Cursor cursor = db.rawQuery(select, null);

        while(cursor.moveToNext()){
            itemProduct itemProduct = new itemProduct();
            itemProduct.setCode(cursor.getInt(0));
            itemProduct.setTitle(cursor.getString(1));
            itemProduct.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setId(cursor.getInt(3));
            category.setName(cursor.getString(4));
            itemProduct.setCategory(category);
            itemProducts.add(itemProduct);
        }
        try{
            cursor.close();
            db.close();
        }catch (Exception e){

        }

        return itemProducts;
    }
}
