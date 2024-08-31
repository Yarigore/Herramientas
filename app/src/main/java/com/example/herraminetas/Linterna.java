package com.example.herraminetas;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Linterna extends Fragment {

    private ImageView botonCamara;
    private boolean encendido;

    public Linterna() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_linterna, container, false);

        botonCamara = (ImageView) view.findViewById(R.id.linterna);
        if (encendido) botonCamara.setBackgroundColor(Color.YELLOW);

        botonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (encendido){
                    botonEncenderFlash();
                }else {
                    botonApagaFlash();
                }
                encendido = !encendido;
            }
        });

        return view;
    }

    public void botonApagaFlash(){
        botonCamara.setBackgroundColor(Color.YELLOW);

        Activity estaActividad = getActivity();
        ((ManejaFlash)estaActividad).enciendeApaga(encendido);
    }

    public void botonEncenderFlash(){
        botonCamara.setBackgroundColor(Color.TRANSPARENT);

        Activity estaActividad = getActivity();
        ((ManejaFlash)estaActividad).enciendeApaga(encendido);
    }
}