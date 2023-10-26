package com.example.myapplication2.clases.sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.List;

public class ListarSensoresActivity extends AppCompatActivity {
    Button button3;
    Button btnlistar;
SensorManager sensorManager;
List<Sensor>  sensores;
TextView textView;
    RecyclerView  rvSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sensores);

        textView = findViewById(R.id.textView);
        button3 = findViewById(R.id.button3);
        btnlistar= findViewById(R.id.btnlistar);
        rvSensor = findViewById(R.id.rvSensor);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        button3.setOnClickListener(mostrarTexto());
        btnlistar.setOnClickListener(enlistar());

    }

    private View.OnClickListener mostrarTexto() {
        return v -> {
            textView.setText(sensores.toString());
            textView.setVisibility(View.VISIBLE);
            rvSensor.setVisibility(View.INVISIBLE);

            textView.setMovementMethod(new ScrollingMovementMethod());

        };
    }

    private View.OnClickListener enlistar() {
        return v -> {
            textView.setVisibility(View.INVISIBLE);
            rvSensor.setVisibility(View.VISIBLE);

            Log.i("EMM", "enlistando");
            SensorPojoHandler sensorPojoHandler = new SensorPojoHandler();
            ArrayList<SensorPOJO> sensoresPojo =sensorPojoHandler.configureJson(sensores);
            Log.i("EMM", "total del sensores "+ sensoresPojo.size());


            // on below line passing our array list to our adapter class.
            SensorRVAdapter sensorRVAdapter = new SensorRVAdapter(sensoresPojo, ListarSensoresActivity.this);

            // setting layout manager for our recycler view.
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListarSensoresActivity.this, RecyclerView.VERTICAL, false);
            rvSensor.setLayoutManager(linearLayoutManager);

            // setting our adapter to recycler view.
            rvSensor.setAdapter(sensorRVAdapter);
        };
    }

}