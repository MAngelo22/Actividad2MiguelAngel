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

        getSupportActionBar().hide();

        TextView titulo2 = (TextView) findViewById(R.id.text2);
     }

    public void crearUsuario (View view){
        //Toast toastUsu = Toast.makeText(this,"Funcion no existe", Toast.LENGTH_LONG);
        //Toast.show();
        Intent cambioUs = new Intent (this, LoginNew.class);
        startActivity(cambioUs);
    }

    public void login (View view){
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.textName);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.textPas);

        if( usuario.getText().toString().equalsIgnoreCase("GOKU")&&
        password.getText().toString().equals("123")){
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }else{

            Toast toastUsu = Toast.makeText(this,"Comprueba nombre y contraseña", Toast.LENGTH_LONG);
            //Toast.show();
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
