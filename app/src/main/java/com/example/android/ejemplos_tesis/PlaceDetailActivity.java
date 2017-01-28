package com.example.android.ejemplos_tesis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class PlaceDetailActivity extends AppCompatActivity {
    private Sitio sitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_detalle_sitios);
        /*Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
         Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        /*if (getIntent().getIntExtra(RecyclerAdapter.PLACE_ID, 0) >= 0) {
            loadDetail(getIntent().getIntExtra(RecyclerAdapter.PLACE_ID, 0));
        }*/
    }

   /* private void loadDetail(int intExtra) {
        this.sitio = PlacesDataProvider.getPlaces().get(intExtra);
        TextView title = (TextView) findViewById(R.id.title_detail);
        TextView description = (TextView) findViewById(R.id.description_detail);
        ImageView imagen = (ImageView) findViewById(R.id.image_toolbars);

        title.setText(sitio.getNombre());
        description.setText(sitio.getNombre());
        imagen.setImageResource(R.mipmap.tower_clock);
    }*/


}

