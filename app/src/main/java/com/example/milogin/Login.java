package com.example.milogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity  {
    Button Admin, Editar, Eliminar;
    Button Cerrar_Session, Nortificacion, Mapa;
    TextView Usuario, Correo, Fecha, Nacionalidad, Opcion;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        preferences = getSharedPreferences("sesiones", Context.MODE_PRIVATE);
        editor = preferences.edit();

        Usuario = findViewById(R.id.textViewUsuario);
        Correo = findViewById(R.id.textViewCorreo);
        Fecha = findViewById(R.id.textViewFecha);
        Nacionalidad = findViewById(R.id.textViewNacionalidad);
        Opcion = findViewById(R.id.opcion_Admin);
        Admin= findViewById(R.id.btnAdmin);
        Editar = findViewById(R.id.btnEditar);
        Eliminar =findViewById(R.id.btnEliminar);


        String usuario = preferences.getString("usuario", "");
        String correo = preferences.getString("correo", "");
        String fecha = preferences.getString("fecha", "");
        String pais = preferences.getString("pais", "");

        Usuario.setText(usuario);
        Correo.setText(correo);
        Fecha.setText(fecha);
        Nacionalidad.setText(pais);
        String Nivel = preferences.getString("nivel", "normi");
        if (Nivel.equals("admin")){
            Opcion.setVisibility(View.VISIBLE);
            Admin.setVisibility(View.VISIBLE);
            Editar.setVisibility(View.VISIBLE);
            Eliminar.setVisibility(View.VISIBLE);
        }else{
            Opcion.setVisibility(View.INVISIBLE);
            Admin.setVisibility(View.INVISIBLE);
            Editar.setVisibility(View.INVISIBLE);
            Eliminar.setVisibility(View.INVISIBLE);
        }


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
