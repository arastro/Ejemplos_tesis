package com.example.android.ejemplos_tesis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IVANF on 21/01/2017.
 */

public class AdaptadorSitio extends ArrayAdapter<Sitio> {

    public AdaptadorSitio (Context context, ArrayList<Sitio> sitios) {
        super(context, 0, sitios);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_lista, parent, false);
        }


        Sitio sitioActual = getItem(position);

        TextView nombre = (TextView)listItemView.findViewById(R.id.nombre_comida);

        nombre.setText(sitioActual.getNombre());

        TextView precio = (TextView)listItemView.findViewById(R.id.precio_comida);

        precio.setText((String.valueOf(sitioActual.getRating())));

        ImageView imagen = (ImageView)listItemView.findViewById(R.id.miniatura_comida);

        imagen.setImageResource(sitioActual.getIdDrawable());

        return listItemView;
    }




}
