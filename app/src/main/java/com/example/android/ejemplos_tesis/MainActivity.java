package com.example.android.ejemplos_tesis;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

/*Ejemplo sencillo de un SearchView pero sin autocompletado(Aun)*/


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Creamos las variables de manera gloval ya que las usaremos en otros metodos*/
    ArrayList<Ciudad> ciudades =new ArrayList<>();
    Toolbar toolbar;
    ListView lista;
    AdapterCiudad adapter;//adaptador para el arraylist de ciudades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos el toolbar donde se agregara el searchView
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Agregamos valores al arrayList de ciudades o sitios
        ciudades.add(new Ciudad(R.drawable.android_perfil,"colombia"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"ecuador"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"bolivia"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"india"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"2"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"3"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"4"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"5"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"6"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"7"));
        ciudades.add(new Ciudad(R.drawable.android_perfil,"8"));


        adapter = new AdapterCiudad(this, ciudades);//Inicializamos el adaptador de ciudades con el contexto y el arraylist de ciudades
        lista = (ListView)findViewById(R.id.reciclador);//buscamos el adaptador de ciudades en el xml
        lista.setAdapter(adapter);//agregamos el adaptador al listview

    }

    //funcion para inicializar el toolbar y el searchview
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    //Las 2 ultimas funciones se agregan por defecto al implementar el Searchview al archivo java
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    //modificamos esta funcion para que cada vez que la persona escriba en el Searchview se vaya modificando la lista
    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<Ciudad> nuevalista = new ArrayList<>();
        for (Ciudad ciudad : ciudades){
            String nombre = ciudad.getNombre().toLowerCase();
            if (nombre.contains(newText)){
                nuevalista.add(ciudad);
            }
        }

        adapter = new AdapterCiudad(this, nuevalista);
        lista.setAdapter(adapter);

        return false;
    }
}
