package com.example.alumno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.alumno.myapplication.activities.AboutUsActivity;
import com.example.alumno.myapplication.activities.ProductlistActivity;
import com.example.alumno.myapplication.generals.Settings;

public class MainActivity extends AppCompatActivity {
    private Button btnProducts;
    private Button btnAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProducts = (Button) findViewById(R.id.btnEnter);
        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        btnProducts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(Settings.INFO, "Products");
                Intent i = new Intent(MainActivity.this, ProductlistActivity.class);
                startActivity(i);
            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(Settings.INFO, "About us");
                Intent i = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(i);
            }
        });
    }
}
