package com.example.myapplication2.ejercicios.holaMundoEx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication2.R;

public class ResultadoHolaExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_hola_ex);


        String nombre = getIntent().getStringExtra("HOLA_MUNDO_NOMBRE");


        TextView tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText(nombre);
    }
}