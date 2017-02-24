package com.example.android.ejemplos_tesis;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/*Ejemplo sencillo de un SearchView pero sin autocompletado(Aun)*/


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {



    public static final String URL="http://ceramicapiga.com/tesis/searchSite.php";
    // Creamos las variables de manera gloval ya que las usaremos en otros metodos*/
    ArrayList<Sitio> ciudades =new ArrayList<>();
    ArrayList<Sitio> listaSitios = new ArrayList<>();
    GetFromUrl Tbuscar =new GetFromUrl();// hilo que se encargara de buscar

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

        if(newText.length()>= 3) {
            newText = newText.toLowerCase();
            GetFromUrl Tbuscar =new GetFromUrl();// hilo que se encargara de buscar
            Tbuscar.execute(newText);

        }
        return false;
    }

    private class GetFromUrl extends AsyncTask<String, Void, Void> {

        private ProgressDialog pDialog;

        JSONObject json = new JSONObject();
        JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String ...nameSite) {


            HashMap<String, String> params = new HashMap<>();
            params.put("name", nameSite[0]);

            Log.i("Tag", "llego Aqui");

            json = jsonParser.makeHttpRequest(URL, "POST", params);
            try {

                JSONArray values = json.getJSONArray("sitios");

                listaSitios = new ArrayList<>();


                    int i = 0;
                    while (i < values.length()) {
                        JSONObject sitioJson = values.getJSONObject(i);
                        int id = sitioJson.getInt("id");
                        String name = sitioJson.getString("nombre");
                        Sitio sitio = new Sitio(R.drawable.android_perfil, name);
                        listaSitios.add(sitio);
                        adapter = new AdapterCiudad(MainActivity.this, listaSitios);
                        i++;
                    }






            } catch (JSONException e) {
                this.cancel(true);
            }
            return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Void aVoid) {


            super.onPostExecute(aVoid);
            lista.setAdapter(adapter);


        }
    }
}

