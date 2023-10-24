package com.example.myapplication2.clases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.InitActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.clases.Fragmentos.ContenedorFragment;
import com.example.myapplication2.clases.HolaMundo.HolaMundo;
import com.example.myapplication2.clases.almacenamiento.AlmacenamientoActivity;

public class MainActivityClases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clases);


        Button holaMundoBtn = (Button) findViewById(R.id.btnHolaMundo);
        holaMundoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivityClases.this, HolaMundo.class);
                startActivity(intent);
            }
        });

        Button btnFragmento = (Button) findViewById(R.id.btnFragmento);
        btnFragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivityClases.this, ContenedorFragment.class);
                startActivity(intent);
            }
        });

        Button btnAlmacenamiento = (Button) findViewById(R.id.btnAlmacenamiento);
        btnAlmacenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivityClases.this, AlmacenamientoActivity.class);
                startActivity(intent);
            }
        });
        
    }

}