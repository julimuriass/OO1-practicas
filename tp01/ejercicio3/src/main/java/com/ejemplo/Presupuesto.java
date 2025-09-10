package com.ejemplo;

import java.time.Instant;
import java.util.Date;

public class Presupuesto {
    Date fecha;
    String cliente;

    //Constructor.
    public Presupuesto(String cliente) {
        this.cliente = cliente;

        Instant now = Instant.now();
        Date date = Date.from(now);
        this.fecha = date;
    }

    //Comportamiento.
    public void agregarItem(Item item) {

    }

    public double calcularTotal() {
        return 0;
    }


    //Getters.
    public String getCliente() {
        return this.cliente;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
