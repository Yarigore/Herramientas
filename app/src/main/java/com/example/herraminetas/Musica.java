package com.example.herraminetas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Musica extends Fragment {

    public boolean encendida;
    private ImageView botonMusica;


    public Musica() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musica, container, false);

        botonMusica = (ImageView) view.findViewById(R.id.musica);

        if (encendida) botonMusica.setBackgroundColor(Color.YELLOW);


        botonMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (encendida) apagaMusica();
                else enciendeMusica();
                encendida = !encendida;
            }
        });
        return view;
    }

    public void enciendeMusica(){
        botonMusica.setBackgroundColor(Color.YELLOW);
        Intent miReproductor = new Intent(getActivity(), ServicioMusica.class);
        getActivity().startService(miReproductor);
    }

    public void apagaMusica(){
        botonMusica.setBackgroundColor(Color.TRANSPARENT);
        Intent miReproductor = new Intent(getActivity(), ServicioMusica.class);
        getActivity().stopService(miReproductor);
    }

}