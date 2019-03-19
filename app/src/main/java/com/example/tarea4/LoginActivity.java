package com.example.tarea4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tarea4.tools.Constants;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.activity_login_input_user);
        password = findViewById(R.id.activity_login_input_pass);
        login = findViewById(R.id.activity_login_btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences(Constants.MAIN_PACKAGE, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constants.USER_PREFERENCE, username.getText().toString());
                editor.putString(Constants.PASSWORD_PREFERENCE, password.getText().toString());
                editor.apply(); //apply asincrono , commit sincrono

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
