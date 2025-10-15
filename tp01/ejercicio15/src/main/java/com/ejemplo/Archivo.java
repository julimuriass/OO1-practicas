package com.ejemplo;

public class Archivo {
    private String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }


    public Integer tamaño(){
        return this.nombre.length();
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
