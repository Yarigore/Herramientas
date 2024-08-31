package com.example.herraminetas;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Menu extends Fragment {

    private final int[] BOTONESMENU = {R.id.linterna, R.id.musica, R.id.nivel};
    private final int[] BOTONESILUMINADOS = {R.drawable.flash, R.drawable.altavoz, R.drawable.nivel};
    private int boton;

    public Menu() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View miMenu =  inflater.inflate(R.layout.fragment_menu, container, false);

        boton = -1;

        if (getArguments() != null) boton = getArguments().getInt("BOTONPULSADO");

        ImageButton botonMenu;

        for (int i = 0; i < BOTONESMENU.length; i++){
            botonMenu = (ImageButton) miMenu.findViewById(BOTONESMENU[i]);

            if (boton == i){
                botonMenu.setImageResource(BOTONESILUMINADOS[i]);
                botonMenu.setBackgroundColor(Color.YELLOW);
            }

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