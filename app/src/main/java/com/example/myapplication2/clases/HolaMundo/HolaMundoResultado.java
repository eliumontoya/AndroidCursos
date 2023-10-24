package com.example.myapplication2.clases.HolaMundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication2.R;

public class HolaMundoResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo_resultado);
        String nombre = getIntent().getStringExtra("EXTRA_NOMBRE");
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        tvResultado.setText("Hola " + nombre
        + " Como estas");
    }
}