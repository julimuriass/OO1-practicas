package com.ejemplo;

import java.util.Date;

public class Ticket {
    Date fecha;
    Integer cantProductos;
    double presioTotal;
    double pesoTotal;

    public Ticket(Date fecha, Integer cantProductos, double presioTotal, double pesoTotal) {
        this.fecha = fecha;
        this.cantProductos = cantProductos;
        this.presioTotal = presioTotal;
        this.pesoTotal = pesoTotal;
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
