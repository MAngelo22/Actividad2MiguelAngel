package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginNew extends AppCompatActivity {

    Button BtnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);

        BtnCrear = (Button) findViewById(R.id.buttonLogin);

        final TextView textName = (TextView) findViewById(R.id.textName);
        final TextView textPassword = (TextView) findViewById(R.id.textPas);

        //Aqui hago un onclick escuchando a la funcion de vaciar
        textName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vista){
                vaciar(textName);
            }
        });
        textPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vista){
                vaciar(textPassword);
            }
        });

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
        View view = inflater.inflate(R.layout.toastnewusu, null);
        Toast toastNewUsu = new Toast (this);
        toastNewUsu.setDuration(Toast.LENGTH_LONG);
        toastNewUsu.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
        toastNewUsu.setView(view);
        toastNewUsu.show();

        MediaPlayer Sonido1 = MediaPlayer.create(this, R.raw.sonidoshenron);
        Sonido1.start();

    }

    public void vaciar(TextView tv){
        tv.setText("");
    }

    public void Cambio(View view) {
        Intent cambio = new Intent(this, Login.class);
        startActivity(cambio);

    }
}