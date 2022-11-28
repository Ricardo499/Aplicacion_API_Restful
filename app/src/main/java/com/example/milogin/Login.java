package com.example.milogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity  {
    Button Cerrar_Session, Nortificacion, Mapa;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        preferences = getSharedPreferences("sesiones", Context.MODE_PRIVATE);
        editor = preferences.edit();
        Cerrar_Session = (Button) findViewById(R.id.cerrar_session);

        Cerrar_Session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("sesion", false);
                editor.apply();
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });
        Nortificacion =(Button) findViewById(R.id.nortificacion);
        Nortificacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, nortificacion.class));
            }
        });
        Mapa =(Button) findViewById(R.id.mapa);
        Mapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, gps.class));
            }
        });

    }
}
