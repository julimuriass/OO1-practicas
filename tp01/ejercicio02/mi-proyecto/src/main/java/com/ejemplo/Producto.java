package com.ejemplo;

public class Producto {
    double peso; //Asumo que peso está en kilos.
    double precioXKilo;
    String descripcion;

    //Constructor.
    public Producto (String descripcion, double peso, double precioXKilo) {
        this.peso = peso;
        this.descripcion = descripcion;
        this.precioXKilo = precioXKilo;
    }

    public double getPrecio() {
        return this.peso * this.precioXKilo;
    }
    
    //Setters.
    public void setPrecioPorKilo(double precio) {
        this.precioXKilo = precio;
    }

    //Getters.
    public double getPeso() { //Está bien el public acá??
        return this.peso;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getPrecioPorKilo() {
        return this.precioXKilo;
    }

    
    
}
