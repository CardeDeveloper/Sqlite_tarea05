package com.example.tarea4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tarea4.beans.City;
import com.example.tarea4.beans.Store;
import com.example.tarea4.beans.User;
import com.example.tarea4.db.DataBaseHandler;
import com.example.tarea4.db.StoreControl;
import com.example.tarea4.tools.Constants;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    public User loadPreferences(){

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.USER_PREFERENCE, MODE_PRIVATE);
        User user = new User();

        user.setName(sharedPreferences.getString("USERNAME", null));
        user.setPassword(sharedPreferences.getString("PASSWORD", null));
        user.setLogged(sharedPreferences.getBoolean("ISLOGGED", false));

        sharedPreferences = null;
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        StoreControl storeControl = new StoreControl();
        DataBaseHandler dataBaseHandler = DataBaseHandler.getInstance(SplashActivity.this);
        ArrayList<Store> stores = storeControl.getStores(dataBaseHandler);

        City city1 = new City(1, "Zapopan");
        City city2 = new City(2, "Guadalajara");
        City city3 = new City(3, "Tlaquepaque");

        if(stores.size() == 0){
            storeControl.addStore(new Store(0, "Best buy Andares", "3318064302", R.drawable.bestbuy, 21.555, -108.343, city1), dataBaseHandler);
            storeControl.addStore(new Store(1, "Best buy Forum Tlaquepaque", "3312015602", R.drawable.bestbuy, 87.235, 103.543, city3), dataBaseHandler);
            storeControl.addStore(new Store(2, "Best buy Galerias", "3312015502", R.drawable.bestbuy, 123.565, 53.643, city2), dataBaseHandler);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                User user = loadPreferences();
                Intent intent;
                if(user.isLogged())
                    intent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                else
                    intent = new Intent().setClass(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
