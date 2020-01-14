package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        getSupportActionBar().hide();

        TextView titulo2 = (TextView) findViewById(R.id.text2);
     }

    public void crearUsuario (View view){

        Intent cambioUs = new Intent (this, LoginNew.class);
        startActivity(cambioUs);
    }

    public void vaciar(TextView tv){
        tv.setText("");
    }

    public void login (View view){
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.textName);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.textPas);
        usuario.getText().toString().replace("","");
        password.getText().toString().replace("","");

        if( usuario.getText().toString().equalsIgnoreCase("GOKU")&&
        password.getText().toString().equals("123")){
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }else{

            Toast toastUsu = Toast.makeText(this,"Comprueba nombre y contraseña", Toast.LENGTH_LONG);
            toastUsu.show();
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
