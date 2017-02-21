package com.example.android.ejemplos_tesis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IVANF on 20/02/2017.
 */

//Adaptador de ciudades (lo normal)

public class AdapterCiudad extends ArrayAdapter<Ciudad> {

    ArrayList arrayList;

    //se agrega el constructor
    public AdapterCiudad(Context context, ArrayList<Ciudad> ciudad) {
        super(context, 0, ciudad);
    }


    //se sobreescribe el metodo getview que se hereda de la clase arrayAdapter
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.row_layout, parent, false);
        }//este if se  agrega por si la lista esta vacia(es solo validacion)


        Ciudad ciudadActual = getItem(position);//capturamos la ciudad actual y la guardamos en un objeto

        //seguidamente agregamos la informacion para que lo muestre el xml
        TextView nombre = (TextView) listItemView.findViewById(R.id.nombre);

        nombre.setText(ciudadActual.getNombre());

        ImageView imagen = (ImageView) listItemView.findViewById(R.id.imagen);

        imagen.setImageResource(ciudadActual.getBandera());

        //devolvemos la lista ya modificada
        return listItemView;
    }


}
