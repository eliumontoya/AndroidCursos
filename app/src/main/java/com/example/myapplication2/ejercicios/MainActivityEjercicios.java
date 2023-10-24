package com.example.myapplication2.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;
import com.example.myapplication2.clases.HolaMundo.HolaMundo;
import com.example.myapplication2.clases.MainActivityClases;
import com.example.myapplication2.ejercicios.framentoex.ContFragExActivity;
import com.example.myapplication2.ejercicios.holaMundoEx.HolaMundoExActivity;

public class MainActivityEjercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ejercicios);


        Button btnHolaMundo = (Button) findViewById(R.id.btnHolaMundo);
        btnHolaMundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivityEjercicios.this, HolaMundoExActivity.class);
                startActivity(intent);
            }
        });

        Button btnFragmento = (Button) findViewById(R.id.btnFragmento);
        btnFragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivityEjercicios.this, ContFragExActivity.class);
                startActivity(intent);
            }
        });
    }

}