package com.example.alumno.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alumno.myapplication.activities.LoginActivity;


public class SplashScreennActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent o = new Intent(this, LoginActivity.class);
        startActivity(o);
        try {
            Thread.sleep (1000);
        }
        catch (Exception e) {
            startActivity(o);
            finish();
        }
    }
}