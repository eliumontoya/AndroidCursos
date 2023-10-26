package com.example.myapplication2.clases.sensores;

import android.hardware.Sensor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SensorPojoHandler {
    ArrayList<SensorPOJO> sensoresPojo = new ArrayList<>();

    public SensorPojoHandler(ArrayList<SensorPOJO> sensoresPojo) {
        this.sensoresPojo = sensoresPojo;
    }

    public SensorPojoHandler() {

    }

    public void configureJson(String jason) {

    }

    public ArrayList<SensorPOJO> configureJson(List<Sensor> sensores) {
        this.sensoresPojo.clear();

        for (Sensor sensor: sensores
             ) {
            this.sensoresPojo.add(new SensorPOJO(sensor.getName(), sensor.toString()));
            Log.i("SensorPojoHandler", this.sensoresPojo.size()+ " Agragando un pojo " + sensor.toString());
        }
        Log.i("SensorPojoHandler", "total agregados " + this.sensoresPojo.size());

        return this.sensoresPojo;
    }
}
