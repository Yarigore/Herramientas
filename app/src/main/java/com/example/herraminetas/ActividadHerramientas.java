package com.example.herraminetas;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu, ManejaFlash{

    private Fragment[] misFragmentos;
    private CameraManager cameraManager;
    private String idCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);

        misFragmentos = new Fragment[3];
        misFragmentos[0] = new Linterna();
        misFragmentos[1] = new Musica();
        misFragmentos[2] = new Nivel();

        Bundle extras = getIntent().getExtras();
        menu(extras.getInt("BOTONPULSADO"));

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            idCamera = cameraManager.getCameraIdList()[0];
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void menu(int boton) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        Fragment menu_iluminado = new Menu();
        Bundle datos = new Bundle();
        datos.putInt("BOTONPULSADO", boton);
        menu_iluminado.setArguments(datos);
        fragmentTransaction.replace(R.id.menu, menu_iluminado);

        fragmentTransaction.replace(R.id.herramientas, misFragmentos[boton]);
        fragmentTransaction.commit();
    }

    @Override
    public void enciendeApaga(boolean estadoFlash) {
        try {
            if (estadoFlash){
                Toast.makeText(this, "Flash apagado", Toast.LENGTH_SHORT).show();
                cameraManager.setTorchMode(idCamera, false);
            }
            else {
                Toast.makeText(this, "Flash encendido", Toast.LENGTH_SHORT).show();
                cameraManager.setTorchMode(idCamera, true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}