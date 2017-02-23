package com.example.android.ejemplos_tesis;

/**
 * Created by IVANF on 20/02/2017.
 */

//Clase ciudad la hice por que se me dio la gana

public class Sitio {

    String nombre;
    int id;

    public Sitio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
