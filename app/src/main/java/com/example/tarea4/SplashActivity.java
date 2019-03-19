package com.example.tarea4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tarea4.tools.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences =
                        getSharedPreferences(Constants.MAIN_PACKAGE, MODE_PRIVATE);
                String username = sharedPreferences.getString(Constants.USER_PREFERENCE, null);
                String password = sharedPreferences.getString(Constants.PASSWORD_PREFERENCE, null);

                if (password == null){
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
