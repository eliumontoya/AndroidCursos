package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.clases.Fragmentos.ContenedorFragment;
import com.example.myapplication2.clases.HolaMundo.HolaMundo;
import com.example.myapplication2.clases.MainActivityClases;
import com.example.myapplication2.ejercicios.MainActivityEjercicios;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);


        Button btnClases = (Button) findViewById(R.id.btnClases);
        btnClases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InitActivity.this, MainActivityClases.class);
                startActivity(intent);
            }
        });

        Button btnEjercicios = (Button) findViewById(R.id.btnEjercicios);
        btnEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InitActivity.this, MainActivityEjercicios.class);
                startActivity(intent);
            }
        });

    }
}