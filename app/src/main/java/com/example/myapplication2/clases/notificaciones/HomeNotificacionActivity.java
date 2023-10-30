package com.example.myapplication2.clases.notificaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication2.R;

public class HomeNotificacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_notificacion);
       String text= getIntent().getStringExtra("mensaje");

        ((TextView) findViewById(R.id.textView4)).setText(text);
    }
}