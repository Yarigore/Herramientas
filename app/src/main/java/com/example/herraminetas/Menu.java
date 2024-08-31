package com.example.herraminetas;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Menu extends Fragment {

    private final int[] BOTONESMENU = {R.id.linterna, R.id.musica, R.id.nivel};

    public Menu() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View miMenu =  inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton botonMenu;

        for (int i = 0; i < BOTONESMENU.length; i++){
            botonMenu = (ImageButton) miMenu.findViewById(BOTONESMENU[i]);
            final int boton = i;
            botonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Activity estaActividad = getActivity();
                    ((ComunicaMenu)estaActividad).menu(boton);
                }
            });
        }

        return miMenu;
    }
}