package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginNew extends AppCompatActivity {

    Button BtnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);

        BtnCrear = (Button) findViewById(R.id.buttonLogin);

        BtnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vista){
                Crear();
            }
        });

        getSupportActionBar().hide();
    }



    public void Crear() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.capatoastcrear, null);
        Toast toastNewUsu = new Toast (this);
        toastNewUsu.setView(view);
        toastNewUsu.setDuration(Toast.LENGTH_LONG);
        toastNewUsu.setGravity(Gravity.TOP, 0, 0);
        toastNewUsu.show();
    }

    public void Cambio(View view) {
        Intent cambio = new Intent(this, Login.class);
        startActivity(cambio);

    }
}