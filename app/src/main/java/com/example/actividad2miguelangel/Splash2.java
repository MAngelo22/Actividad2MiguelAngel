package com.example.actividad2miguelangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actividad2miguelangel.R;

public class Splash2 extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        getSupportActionBar().hide();

        TextView titulo = (TextView) findViewById(R.id.text1);
        ImageView dragonball = (ImageView) findViewById(R.id.esferas);

        Animation rotar = AnimationUtils.loadAnimation(this,R.anim.rotar);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animacion);
        titulo.startAnimation(anim);
        dragonball.startAnimation(rotar);
        anim.setAnimationListener(this);
        rotar.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent transicion = new Intent(this,Login.class);
        startActivity(transicion);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
