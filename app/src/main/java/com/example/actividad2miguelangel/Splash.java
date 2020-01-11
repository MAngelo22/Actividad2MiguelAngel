package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Typeface  miFuente = Typeface.createFromAsset(getAssets(),"saiyansans.ttf");
        TextView titulo = (TextView) findViewById(R.id.text1);

        titulo.setTypeface(miFuente);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animacion);
    }
}
