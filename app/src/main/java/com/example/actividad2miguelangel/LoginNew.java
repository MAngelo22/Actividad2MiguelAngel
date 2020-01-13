package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);

        getSupportActionBar().hide();
    }

    public void Crear(View view) {
        Toast toastNewUsu = Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_LONG);
        toastNewUsu.show();
    }

    public void Cambio(View view) {
        Intent cambio = new Intent(this, Login.class);
        startActivity(cambio);

    }
}