package com.example.tarea4.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tarea4.beans.Category;

import java.util.ArrayList;

public class CategoryControl {

    public ArrayList<Category> getCategories(DataBaseHandler dh){
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<Category> categories = new ArrayList<>();

        String select = "SELECT DataBaseHandler.KEY_CATEGORY_ID, DataBaseHandler.KEY_CATEGORY_NAME FROM category";
        Cursor cursor = db.rawQuery(select, null);
        while(cursor.moveToNext()){
            Category category = new Category();
            category.setId(cursor.getInt(0));
            category.setName(cursor.getString(1));
            categories.add(category);
        }
        try{
            cursor.close();
            db.close();
        }catch (Exception e){

        }

        return categories;
    }
}
