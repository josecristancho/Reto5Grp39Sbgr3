package com.example.fest.Vista.Splash;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fest.Controlador.MainActivity;
import com.example.fest.R;

public class SplashScreen extends AppCompatActivity implements Runnable {
    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView logofestapp = (ImageView)findViewById(R.id.logofestapp);
        logofestapp.setBackgroundResource(R.drawable.logofestapp);

        AnimationDrawable ejecutarAnimacion = (AnimationDrawable)logofestapp.getBackground();
        ejecutarAnimacion.start();

        //***********************
        h1= new Thread(this);
        h1.start();
        //***********************

    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
