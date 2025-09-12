package com.ejemplo;

public class Item {
    String detalle;
    Integer cantidad;
    double costoUnitario;

    //Constructor.
    public Item(String detalle, Integer cantidad, double costoUnitario) { 
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.costoUnitario = costoUnitario;
    }

    //Comportamiento.
    public double costo() {
        return this.cantidad * this.costoUnitario;
    }

    //Getters.
    public double getCostoUnitario() {
        return this.costoUnitario;
    }
    
    public Integer getCantidad() {
        return this.cantidad;
    }
}
