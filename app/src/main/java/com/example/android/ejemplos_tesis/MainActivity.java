package com.example.android.ejemplos_tesis;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String URL="http://ceramicapiga.com/tesis/get5sites.php";
    private ArrayList<Sitio> sitios = new ArrayList<Sitio>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        GetFromUrl tsk = new GetFromUrl();
        tsk.execute();

        // sitios.add(new Sitio(5, "Camarones Tismados", R.drawable.background));



       /* AdaptadorSitio adapter = new AdaptadorSitio(this, sitios);

        ListView lista = (ListView)findViewById(R.id.reciclador);

        lista.setAdapter(adapter); */


    }

    private class GetFromUrl extends AsyncTask<Void, Void ,Void>{

        private ProgressDialog pDialog;

        JSONObject json = new JSONObject();
        JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Cargando Imagen");
            pDialog.setCancelable(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... param) {
            Bitmap imagen=null;
            HashMap<String, String> params = new HashMap<>();
            params.put("user", "user");

            Log.i("Tag", "llego Aqui");

            json = jsonParser.makeHttpRequest(URL, "POST", params);
            try {
                JSONArray values = json.getJSONArray("sitios");

                for (int i=0; i<values.length(); i++){
                    JSONObject sitioJson = values.getJSONObject(i);
                    int id = sitioJson.getInt("id");
                    String name = sitioJson.getString("nombre");
                    imagen = descargarImagen(sitioJson.getString("ulr"));
                    sitios.add(new Sitio(id, name, imagen));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


                AdaptadorSitio adapter = new AdaptadorSitio(MainActivity.this, sitios);

                ListView lista = (ListView)findViewById(R.id.reciclador);

                lista.setAdapter(adapter);
            pDialog.dismiss();

        }

        private Bitmap descargarImagen (String imageHttpAddress){
            URL imageUrl = null;
            Bitmap imagen = null;
            try{
                imageUrl = new URL(imageHttpAddress);
                HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                conn.connect();
                imagen = BitmapFactory.decodeStream(conn.getInputStream());
            }catch(IOException ex){
                ex.printStackTrace();
            }

            return imagen;
        }
    }



}
