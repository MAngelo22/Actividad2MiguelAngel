package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Typeface miFuente = Typeface.createFromAsset(getAssets(),"saiyansans.ttf");
        TextView titulo2 = (TextView) findViewById(R.id.text2);

        titulo2.setTypeface(miFuente);
    }

    public void crearUsuario (View view){
        Toast toastUsu = Toast.makeText(this,"Funcion no existe", Toast.LENGTH_LONG);
        //Toast.show();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent cambio = new Intent (Login.this,MainActivity.class);
        //Meto contaseña y usuario
        //startActivity(cambio);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
