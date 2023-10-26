package com.example.myapplication2.clases.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class SensoresMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores_main);


        ((Button) findViewById(R.id.btnListSensors)).setOnClickListener(listar());


        ((Button) findViewById(R.id.btnAcelerometro)).setOnClickListener(accelerometro());
        ((Button) findViewById(R.id.btnGravity)).setOnClickListener(gravity());
        ((Button) findViewById(R.id.btnCamara)).setOnClickListener(camara());

    }

    private View.OnClickListener accelerometro() {
        return v -> {
            Intent intent = new Intent(SensoresMainActivity.this, SensorAcceleromtroActivity.class);
            startActivity(intent);
        };
    }

    private View.OnClickListener listar() {
        return v -> {
            Intent intent = new Intent(SensoresMainActivity.this, ListarSensoresActivity.class);
            startActivity(intent);
        };

    }

    private View.OnClickListener gravity() {
        return v -> {
            Intent intent = new Intent(SensoresMainActivity.this, SensorGravityActivity.class);
            startActivity(intent);
        };
    }

    private View.OnClickListener camara() {
        return v -> {
            Intent intent = new Intent(SensoresMainActivity.this, CamaraActivity.class);
            startActivity(intent);
        };
    }
}