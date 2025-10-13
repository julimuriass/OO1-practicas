package com.ejemplo;

import java.util.List;

public class AccionInversion implements Inversion{
    private String nombre;
    private double cantidad;
    private double valorUnitario;
    

    public AccionInversion(String nombre, double cantidad, double valorUnitario) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    
    public double calcularValor() {
        return this.cantidad * this.valorUnitario;
    }

    public void aumentarCantidad(double cantidad) {
        this.cantidad += cantidad;
    }
}
