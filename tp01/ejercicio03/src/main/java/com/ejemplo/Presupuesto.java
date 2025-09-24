package com.ejemplo;

import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;

public class Presupuesto {
    Date fecha;
    String cliente;
    ArrayList<Item> items;

    //Constructor.
    public Presupuesto(String cliente) {
        this.cliente = cliente;

        //Instant now = Instant.now();
        this.fecha = new Date();

        this.items = new ArrayList<Item>();
    }

    //Comportamiento.
    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        double sumaPrecio = 0; //Inicializo variable.

        Iterator<Item> iterator = this.items.iterator(); //Instancio un iterator sobre la lista de items.
        while (iterator.hasNext()) { //-> Stream !!!!!!!!!!!
            Item item = iterator.next();
            sumaPrecio += item.getCantidad() * item.getCostoUnitario(); //hacerlo método de item. le corresponde a él.
        }

        return sumaPrecio;
    }


    //Getters.
    public String getCliente() {
        return this.cliente;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
