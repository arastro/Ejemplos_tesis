package com.example.android.ejemplos_tesis;

/**
 * Created by IVANF on 20/02/2017.
 */

//Clase ciudad la hice por que se me dio la gana

public class Ciudad {

    String nombre;
    int bandera;

    public Ciudad(int bandera, String nombre) {
        this.bandera = bandera;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
}
