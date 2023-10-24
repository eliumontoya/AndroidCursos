package com.example.myapplication2.ejercicios.holaMundoEx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication2.R;
import com.example.myapplication2.ejercicios.MainActivityEjercicios;

public class HolaMundoExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo_ex);

        Button enviar = findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombre = findViewById(R.id.nombre);
                String n = nombre.getText().toString();
                Log.i("EMM","El nombre es "+n);

                Intent intent = new Intent(HolaMundoExActivity.this, ResultadoHolaExActivity.class);
                intent.putExtra("HOLA_MUNDO_NOMBRE", n);
                startActivity(intent);
            }
        });

    }

}