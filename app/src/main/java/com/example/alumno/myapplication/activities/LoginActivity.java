package com.example.alumno.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumno.myapplication.MainActivity;
import com.example.alumno.myapplication.R;
import com.example.alumno.myapplication.generals.Settings;

public class LoginActivity extends AppCompatActivity {

    Button Button;
    EditText password;
    EditText usuario;
    // ArrayList<User> listaUsuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button boton =(Button) findViewById(R.id.btnStart);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario =((EditText) findViewById(R.id.txtUsername)).getText().toString();
                String paswoord =((EditText) findViewById(R.id.txtPassword)).getText().toString();
                if (usuario.equals("roma")&& paswoord.equals(("123")))
                {
                    Intent nuevoform = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(nuevoform);
                }else
                {
                    Toast.makeText(getApplicationContext(),"usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}