package com.example.herraminetas;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Nivel extends Fragment implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;
    private NivelPantalla pantalla;

    public Nivel() {

    }

    public final void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        int lado = getResources().getDimensionPixelSize(R.dimen.maximo);

        pantalla = new NivelPantalla(getActivity(), lado);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_nivel, container, false);

        return pantalla;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        pantalla.angulos(sensorEvent.values);
    }

    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}