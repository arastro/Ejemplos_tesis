package com.example.android.ejemplos_tesis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Sitio> COMIDAS_POPULARES = new ArrayList<Sitio>();

        COMIDAS_POPULARES.add(new Sitio(5, "Camarones Tismados", R.drawable.background));
        COMIDAS_POPULARES.add(new Sitio(3.2f, "Rosca Herbárea", R.drawable.background));
        COMIDAS_POPULARES.add(new Sitio(12f, "Sushi Extremo", R.drawable.background));
        COMIDAS_POPULARES.add(new Sitio(9, "Sandwich Deli", R.drawable.background));
        COMIDAS_POPULARES.add(new Sitio(34f, "Lomo De Cerdo Austral", R.drawable.background));


        AdaptadorSitio adapter = new AdaptadorSitio(this, COMIDAS_POPULARES);

        ListView lista = (ListView)findViewById(R.id.reciclador);

        lista.setAdapter(adapter);


    }
}
