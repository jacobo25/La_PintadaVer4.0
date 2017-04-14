package com.example.jacobo.la_pintada;

/**
 * Created by admin on 13/03/2017.
 */

public class Lista_Entrada {
    private int idImagen;
    private String nombre;

    public Lista_Entrada(int idImagen, String nombre) {
        this.idImagen = idImagen;
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


