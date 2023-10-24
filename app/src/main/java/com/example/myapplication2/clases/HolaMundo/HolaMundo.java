package com.example.myapplication2.clases.HolaMundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication2.R;

public class HolaMundo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo);
        Button boton = (Button) findViewById(R.id.enviar);
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText text =    (EditText) findViewById(R.id.nombreField);
                String nombre = text.getText().toString();
                Log.i("EMM", "onCreate: nombre " + nombre);

                Intent intent = new Intent(HolaMundo.this, HolaMundoResultado.class);
                intent.putExtra("EXTRA_NOMBRE", nombre);
                startActivity(intent);
            }
        });


    }
    private void onBotonClick(){
        EditText text =    (EditText) findViewById(R.id.nombreField);
        String nombre = text.getText().toString();
        Log.i("EMM", "onCreate: nombre " + nombre);
    }
}