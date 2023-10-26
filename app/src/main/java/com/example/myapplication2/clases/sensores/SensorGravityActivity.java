package com.example.myapplication2.clases.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication2.R;

public class SensorGravityActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_gravity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorManager.registerListener(SensorGravityActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        Log.i("Sensor", "Registrado sensor");
    }

    TextView tvY, tvX, tvZ;

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.i("Sensor", "Cambio valores x:" + event.values[0] + " Y:" + event.values[1] + " Y:" + event.values[2]);
        tvX = findViewById(R.id.tvX);
        tvY = findViewById(R.id.tvY);
        tvZ = findViewById(R.id.tvZ);

        tvX.setText(event.values[0] + "");
        tvY.setText(event.values[1] + "");
        tvZ.setText(event.values[2] + "");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}