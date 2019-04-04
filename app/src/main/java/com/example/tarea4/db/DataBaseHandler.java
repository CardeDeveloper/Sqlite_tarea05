package com.example.tarea4.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DataBaseHandler extends SQLiteOpenHelper {

    private static DataBaseHandler dataBaseHandler;
    //database
    public static final String DATABASE_NAME = "MyProducts.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_STORE = "store";
    public static final String TABLE_PRODUCT = "product";
    public static final String TABLE_CITY = "city";
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_STORE_PRODUCT = "storeProduct";
    // Store
    public static final String KEY_STORE_ID = "idStore";
    public static final String KEY_STORE_NAME = "name";
    public static final String KEY_STORE_PHONE = "phone";
    public static final String KEY_STORE_CITY = "idCity";
    public static final String KEY_STORE_THUMBNAIL = "thumbnail";
    public static final String KEY_STORE_LAT = "latitude";
    public static final String KEY_STORE_LNG = "longitude";

    // Columns Cities
    public static final String KEY_CITY_ID = "idCity";
    public static final String KEY_CITY_NAME = "name";
    // Columns Category
    public static final String KEY_CATEGORY_ID = "idCategory";
    public static final String KEY_CATEGORY_NAME = "name";
    // Columns Products
    public static final String KEY_PRODUCT_ID = "idProduct";
    public static final String KEY_PRODUCT_TITLE = "name";
    public static final String KEY_PRODUCT_IMAGE = "image";
    public static final String KEY_PRODUCT_CATEGORY = "idCategory";
    //StoreProduct table's columns
    public static final String KEY_STORE_PRODUCT_ID = "id";
    public static final String KEY_STORE_PRODUCT_ID_PRODUCT = "idProduct";
    public static final String KEY_STORE_PRODUCT_ID_STORE = "idStore";


    private DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static DataBaseHandler getInstance(Context context){
        if(dataBaseHandler == null){
            dataBaseHandler = new DataBaseHandler(context);
        }
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating city table
        String CREATE_CITY_TABLE = "CREATE TABLE " + TABLE_CITY +
                "(" + KEY_CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_CITY_NAME + " TEXT)";
        db.execSQL(CREATE_CITY_TABLE);

        //inserting cities
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Zapopan')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Guadalajara')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Tlaquepaque')");

        //creating Category table
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY +
                "(" + KEY_CATEGORY_ID + " INTEGER PRIMARY KEY, "
                + KEY_CATEGORY_NAME + " TEXT)";
        db.execSQL(CREATE_CATEGORY_TABLE);

        //Inserting 3 categories
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_ID + ", " + KEY_CATEGORY_NAME + ") VALUES (0, 'TECHNOLOGY')");
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_ID + ", " + KEY_CATEGORY_NAME + ") VALUES (1, 'HOME')");
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_ID + ", " + KEY_CATEGORY_NAME + ") VALUES (2, 'ELECTRONICHS')");


        //creating store table
        String CREATE_STORE_TABLE = "CREATE TABLE " + TABLE_STORE +
                "(" + KEY_STORE_ID + " INTEGER PRIMARY KEY, "
                + KEY_STORE_NAME + " TEXT, "
                + KEY_STORE_PHONE + " TEXT, "
                + KEY_STORE_CITY + " INTEGER, "
                + KEY_STORE_THUMBNAIL + " INTEGER, "
                + KEY_STORE_LAT + " DOUBLE, "
                + KEY_STORE_LNG + " DOUBLE)";
        db.execSQL(CREATE_STORE_TABLE);

        //creating product table
        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT +
                "(" + KEY_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_PRODUCT_TITLE + " TEXT, "
                + KEY_PRODUCT_IMAGE + " INTEGER, "
                + KEY_PRODUCT_CATEGORY + " INTEGER)";
        db.execSQL(CREATE_PRODUCT_TABLE);

        //creating storeproduct table
        String CREATE_STORE_PRDUCT_TABLE = "CREATE TABLE " + TABLE_STORE_PRODUCT +
                "(" + KEY_STORE_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_STORE_PRODUCT_ID_PRODUCT + " INTEGER, "
                +KEY_STORE_PRODUCT_ID_STORE + "INTEGER)";
        db.execSQL(CREATE_STORE_PRDUCT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this is the first Version of the DB
    }
}
