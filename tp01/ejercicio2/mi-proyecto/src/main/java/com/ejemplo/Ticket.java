package com.ejemplo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
    Date fecha;
    Integer cantProductos;
    double presioTotal;
    double pesoTotal;
    ArrayList<Producto> productos;

    public Ticket(Date fecha, Integer cantProductos, double presioTotal, double pesoTotal) {
        this.fecha = fecha;
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

    public Date getFecha() {
        return this.fecha;
    }
}
