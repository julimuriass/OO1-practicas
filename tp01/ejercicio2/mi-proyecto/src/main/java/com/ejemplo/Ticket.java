package com.ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
    LocalDate fecha;
    Integer cantProductos;
    double presioTotal;
    double pesoTotal;
    ArrayList<Producto> productos;

    public Ticket(Integer cantProductos, double presioTotal, double pesoTotal) {
        this.fecha = LocalDate.now();
        this.cantProductos = cantProductos;
        this.presioTotal = presioTotal;
        this.pesoTotal = pesoTotal;

        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() { 
        return this.productos;
    }

    double impuesto() {
        return this.presioTotal * 0.21;
    }

    //Getters.
    public double getPesoTotal() {
        return this.pesoTotal;
    }

    public double getPrecioTotal() {
        return this.presioTotal;
    }

    public Integer getCantidadDeProductos() {
        return this.cantProductos;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
}
